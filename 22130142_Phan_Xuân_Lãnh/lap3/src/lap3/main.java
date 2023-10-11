package lap3;

public class main {
	public static void main(String[] args) {
        // Example usage
        int[] myArray = {12, 10, 9, 45, 2, 10, 10, 45};
        MyArray arr = new MyArray(myArray);

        // Example usage of linearSearch
        int target = 45;
        int linearSearchResult = arr.linearSearch(target);
        System.out.println("Index of " + target + " using linear search: " + linearSearchResult);

        // Example usage of binarySearch
        arr.sortArrayDescending(); // First, the array needs to be sorted in descending order
        int binarySearchResult = arr.binarySearch(target);
        System.out.println("Index of " + target + " using binary search: " + binarySearchResult);
    }
}
