package lap4;


import java.util.Arrays;

public class ex1 {
    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
           
            int temp = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                  
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] < key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }
    
    public static void selectionSort(Order[] orders) {
        int n = orders.length;
        
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (orders[j].getTotalValue() > orders[maxIndex].getTotalValue()) {
                    maxIndex = j;
                }
            }
            // Swapping elements
            Order temp = orders[maxIndex];
            orders[maxIndex] = orders[i];
            orders[i] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 9, 1};
        Order[] orders = {new Order(0), new Order(50), new Order(80)};

      
        System.out.println("Original array: " + Arrays.toString(numbers));
        selectionSort(numbers);
        System.out.println("Sorted array (selection sort): " + Arrays.toString(numbers));

        
        System.out.println("Original array: " + Arrays.toString(numbers));
        bubbleSort(numbers);
        System.out.println("Sorted array (bubble sort): " + Arrays.toString(numbers));

      
        System.out.println("Original array: " + Arrays.toString(numbers));
        insertionSort(numbers);
        System.out.println("Sorted array (insertion sort): " + Arrays.toString(numbers));

        System.out.println("Original array: " + Arrays.toString(orders));
        selectionSort(orders);
        System.out.println("Sorted array (selection sort): " + Arrays.toString(orders));
    }
}
