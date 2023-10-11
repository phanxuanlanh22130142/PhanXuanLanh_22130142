package lap2;

public class Task1_4 {
	public static class TowersOfHanoi {

		  public static void moveDisk(int disk, String source, String destination, String spare) {
		    if (disk == 0) {
		      System.out.println("Move disk 1 from " + source + " to " + destination);
		    } else {
		      moveDisk(disk - 1, source, spare, destination);
		      System.out.println("Move disk " + disk + " from " + source + " to " + destination);
		      moveDisk(disk - 1, spare, destination, source);
		    }
		  }

		  public static void solveTowersOfHanoi(int numDisks, String source, String destination, String spare) {
		    moveDisk(numDisks, source, destination, spare);
		  }

		  public static void main(String[] args) {
		    int numDisks = 3;
		    String source = "A";
		    String destination = "C";
		    String spare = "B";
		    solveTowersOfHanoi(numDisks, source, destination, spare);
		  }
		}
}
