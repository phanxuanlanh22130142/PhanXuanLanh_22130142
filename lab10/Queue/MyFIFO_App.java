package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyFIFO_App {
    public static <E> void stutter(Queue<E> input) {
        int originalSize = input.size();
        for (int i = 0; i < originalSize; i++) {
            E element = input.poll();
            input.offer(element);
            input.offer(element);
        }
    }

    public static <E> void mirror(Queue<E> input) {
    	int originalSize = input.size();
        Stack<E> stack = new Stack<>();
        
      
        for (int i = 0; i < originalSize; i++) {
            E element = input.poll();
            stack.push(element);
            input.offer(element);
        }
        
        
        for (int i = 0; i < originalSize; i++) {
            E element = stack.pop();
            input.offer(element);
        }}

    public static void main(String[] args) {
       
        Queue<Integer> numbers = new LinkedList<>();
        numbers.offer(1);
        numbers.offer(2);
        numbers.offer(3);
        
        System.out.println("Queue trước khi stutter: " + numbers);
        MyFIFO_App.stutter(numbers);
        System.out.println("Queue sau khi stutter: " + numbers);

        
        Queue<String> words = new LinkedList<>();
        words.offer("one");
        words.offer("two");
        words.offer("three");
        
        System.out.println("Queue trước khi mirror: " + words);
        MyFIFO_App.mirror(words);
        System.out.println("Queue sau khi mirror: " + words);
    }
}
