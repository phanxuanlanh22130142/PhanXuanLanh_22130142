package lap4;
import java.util.Arrays;

public class SortingAlgorithms {
  
    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int middle = array.length / 2;
        int[] leftHalfArray = mergeSort(Arrays.copyOfRange(array, 0, middle));
        int[] rightHalfArray = mergeSort(Arrays.copyOfRange(array, middle, array.length));
        return merge(leftHalfArray, rightHalfArray);
    }
  
    private static int[] merge(int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int[] mergedArray = new int[leftLength + rightLength];
        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                mergedArray[k++] = left[i++];
            } else {
                mergedArray[k++] = right[j++];
            }
        }
        while (i < leftLength) {
            mergedArray[k++] = left[i++];
        }
        while (j < rightLength) {
            mergedArray[k++] = right[j++];
        }
        return mergedArray;
    }
  
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
  
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }
  
    private static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low + 1, j = high;
        while (i <= j) {
            while (i <= j && array[i] <= pivot) {
                i++;
            }
            while (i <= j && array[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[low];
        array[low] = array[j];
        array[j] = temp;
        return j;
    }
  
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 9, 1};
        System.out.println("Original array: " + Arrays.toString(array));
      
        int[] mergeSortedArray = mergeSort(array);
        System.out.println("Sorted array (merge sort): " + Arrays.toString(mergeSortedArray));
      
        int[] array2 = {5, 2, 8, 9, 1};
        quickSort(array2);
        System.out.println("Sorted array (quick sort with first pivot): " + Arrays.toString(array2));
    }
}

