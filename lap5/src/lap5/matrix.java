package lap5;

public class matrix {
	public static int[][] add(int[][] a, int[][] b) {
	    
	    if (a.length != b.length || a[0].length != b[0].length) {
	        throw new IllegalArgumentException("Matrices must have the same dimensions");
	    }
	    
	    int rows = a.length;
	    int cols = a[0].length;
	    int[][] result = new int[rows][cols];
	    
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            result[i][j] = a[i][j] + b[i][j];
	        }
	    }
	    
	    return result;
	}
	public static int[][] subtract(int[][] a, int[][] b) {
	    
	    if (a.length != b.length || a[0].length != b[0].length) {
	        throw new IllegalArgumentException("Matrices must have the same dimensions");
	    }
	    
	    int rows = a.length;
	    int cols = a[0].length;
	    int[][] result = new int[rows][cols];
	    
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            result[i][j] = a[i][j] - b[i][j];
	        }
	    }
	    
	    return result;
	}
	public static int[][] multiply(int[][] a, int[][] b) {
	    
	    if (a[0].length != b.length) {
	        throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix");
	    }
	    
	    int rows = a.length;
	    int cols = b[0].length;
	    int[][] result = new int[rows][cols];
	    
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            for (int k = 0; k < a[0].length; k++) {
	                result[i][j] += a[i][k] * b[k][j];
	            }
	        }
	    }
	    
	    return result;
	}
	public static int[][] transpose(int[][] a) {
	    int rows = a.length;
	    int cols = a[0].length;
	    int[][] result = new int[cols][rows];
	    
	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            result[j][i] = a[i][j];
	        }
	    }
	    
	    return result;
	}
	 public static void main(String[] args) {
	       
	        int[][] matrix1 = {
	            {1, 2, 3},
	            {4, 5, 6},
	            {7, 8, 9}
	        };
	        
	        int[][] matrix2 = {
	            {9, 8, 7},
	            {6, 5, 4},
	            {3, 2, 1}
	        };
	        
	       
	        int[][] additionResult = matrix.add(matrix1, matrix2);
	        System.out.println("Addition Result:");
	        printMatrix(additionResult);
	        
	       
	        int[][] subtractionResult = matrix.subtract(matrix1, matrix2);
	        System.out.println("Subtraction Result:");
	        printMatrix(subtractionResult);
	        
	       
	        int[][] multiplicationResult = matrix.multiply(matrix1, matrix2);
	        System.out.println("Multiplication Result:");
	        printMatrix(multiplicationResult);
	        
	        
	        int[][] transposeResult = matrix.transpose(matrix1);
	        System.out.println("Transpose Result:");
	        printMatrix(transposeResult);
	    }
	    
	    public static void printMatrix(int[][] matrix) {
	        for (int[] row : matrix) {
	            for (int element : row) {
	                System.out.print(element + " ");
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }
	}

