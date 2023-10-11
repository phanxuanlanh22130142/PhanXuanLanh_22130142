package lap3;

import java.util.Arrays;

public class MyArray {
    private int[] array;

    public MyArray(int[] array) {
        this.array = array;
    }

    // Linear search
    public int linearSearch(int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary search
    public int binarySearch(int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    // Linear search in descending order
    public int linearSearchDescending(int target) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary search in descending order
    public int binarySearchDescending(int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    // Sort the array in descending order
    public void sortArrayDescending() {
        Arrays.sort(array);
        reverseArray();
    }

    // Reverse the array
    private void reverseArray() {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}

