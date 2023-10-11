package lap2;

public class Task1_1_A {
	  public static int getSn2(int n) {
	        if (n == 1) {
	            return 1;
	        } else {
	            return getSn2(n-1) * n + getFactorial(n-1);
	        }
	    }
	    
	    public static int getFactorial(int n) {
	        if (n == 1) {
	            return 1;
	        } else {
	            return getFactorial(n-1) * n;
	        }
	    }

	    public static void main(String[] args) {
	        int n = 6;
	        int result = getSn2(n);
	        System.out.println("Giá trị của S(" + n + ") là " + result);
	    }
	}

