package lap2;

public class Task1_1_D {
	public static double getSn4(int n) {
		  if (n == 0) {
		    return 1.0;
		  } else {
		    double denominator = 1.0;
		    for (int i = 1; i <= 2 * n; i += 2) {
		      denominator *= i;
		    }
		    return 1 / denominator + getSn4(n - 1);
		  }
		}
}
