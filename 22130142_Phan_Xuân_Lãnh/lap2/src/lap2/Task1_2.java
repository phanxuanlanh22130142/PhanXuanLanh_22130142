package lap2;

public class Task1_2 {
	public static void main(String[] args) {
        int n = 10;
        System.out.println("Dãy Fibonacci có " + n + " số hạng:");
        printFibonacci(n);
    }

  
    public static int getFibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
    }


    public static void printFibonacci(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(getFibonacci(i) + " ");
        }
    }
}
