package Stack;
import java.util.ArrayDeque;
import java.util.Deque;



public class MyLIFO_App {
    public static <E> void reserve(E[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Mảng không được null");
        }
        Deque<E> stack = new ArrayDeque<>();
        for (E item : array) {
            stack.push(item);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }

    public static boolean isCorrect(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Chuỗi không được null");
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            } else if (c == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            } else if (c == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static int evaluateExpression(String biểuThức) {
        int result = 0;
        int num = 0;
        char sign = '+';

        for (int i = 0; i < biểuThức.length(); i++) {
            char c = biểuThức.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == biểuThức.length() - 1) {
                if (sign == '+') {
                    result += num;
                } else if (sign == '-') {
                    result -= num;
                }
                sign = c;
                num = 0;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Mảng trước khi đảo: " + java.util.Arrays.toString(intArray));
        MyLIFO_App.reserve(intArray);
        System.out.println("Mảng sau khi đảo: " + java.util.Arrays.toString(intArray));

        
        String input1 = "{[()()]}";
        String input2 = "{[()()]";
        System.out.println("Chuỗi " + input1 + " là chuỗi hợp lệ: " + MyLIFO_App.isCorrect(input1));
        System.out.println("Chuỗi " + input2 + " là chuỗi hợp lệ: " + MyLIFO_App.isCorrect(input2));

        
        String mathExpression = "4 - 1 * (3 + 5)";
        System.out.println("Kết quả của biểu thức " + mathExpression + " là: " + MyLIFO_App.evaluateExpression(mathExpression));
        String expression1 = "2 + 3 - 1";
        String expression2 = "4 - 2 + 5";
        
        System.out.println("Kết quả của biểu thức " + expression1 + " là: " + MyLIFO_App.evaluateExpression(expression1));
        System.out.println("Kết quả của biểu thức " + expression2 + " là: " + MyLIFO_App.evaluateExpression(expression2));
    }
}
