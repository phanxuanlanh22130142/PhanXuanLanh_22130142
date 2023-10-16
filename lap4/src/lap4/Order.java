package lap4;

public class Order {
    
    
    public Order(int i) {
		
	}

	public static void swap(Order[] array, int i, int j) {
        Order temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static void selectionSort(Order[] array) {
        int n = array.length;

        for (int i = 0; i < n-1; i++) {
            int maxIndex = i;
            for (int j = i+1; j < n; j++) {
                if (array[j].getTotalValue() > array[maxIndex].getTotalValue()) {
                    maxIndex = j;
                }
            }
            
            swap(array, maxIndex, i);
        }
    }

    public int getTotalValue() {
       
        return 0;
    }
}

