package lap2;

public class Task1_1_B {
	 public static int getSn1(int n) {
	        if (n == 1) {
	            return 1;
	        } else {
	            int sign = ((n % 2 == 0) ? -1 : 1);
	            return sign * n + getSn1(n - 1);
	        }
	    }

	    public static void main(String[] args) {
	        int n = 7;
	        int result = getSn1(n);
	        System.out.println("Giá trị của S(" + n + ") là " + result);
	    }
	}

