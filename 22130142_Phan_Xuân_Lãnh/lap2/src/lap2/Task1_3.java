package lap2;



public class Task1_3 {
	 public static class PascalTriangle {
	        
	        public static void printPascalTriangle(int row) {
	            for (int i = 1; i <= row; i++) {
	                int[] currentRow = getPascalTriangle(i);
	                for (int j = 0; j < currentRow.length; j++) {
	                    System.out.print(currentRow[j] + " ");
	                }
	                System.out.println();
	            }
	        }
	        
	        
	        public static int[] getPascalTriangle(int n) {
	            if (n == 1) {
	                return new int[]{1};
	            } else {
	                int[] prevRow = getPascalTriangle(n - 1);
	                return generateNextRow(prevRow);
	            }
	        }
	        
	       
	        public static int[] generateNextRow(int[] prevRow) {
	            int[] nextRow = new int[prevRow.length + 1];
	            nextRow[0] = 1;
	            nextRow[prevRow.length] = 1;
	            for (int i = 1; i < prevRow.length; i++) {
	                nextRow[i] = prevRow[i - 1] + prevRow[i];
	            }
	            return nextRow;
	        }
	    }
	    
	    public static void main(String[] args) {
	        int numRows = 7
	        		;
	        PascalTriangle.printPascalTriangle(numRows);
	    }
}
