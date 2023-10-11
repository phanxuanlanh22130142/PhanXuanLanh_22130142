package lap2;

public class Task1_1_C {
	public static int getSn3(int n) {
	    if (n == 1) {
	        return 1;
	    } else {
	        int square = n * n;
	        return square + getSn3(n - 1);
	    }
	}

	public static void main(String[] args) {
	    int n = 6;
	    int result = getSn3(n);
	    System.out.println("Giá trị của S(" + n + ") là " + result);
	}
}
