package lap_1;

public class MyArray {
private int[] array;
    
    public MyArray(int[] array) {
        this.array = array;
    }
    
    
    public int[] mirror() {
        int[] mirroredArray = new int[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            mirroredArray[i] = array[i];
            mirroredArray[mirroredArray.length - i - 1] = array[i];
        }
        return mirroredArray;
    }
    
   
    public int[] removeDuplicates() {
        int[] uniqueArray = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < index; j++) {
                if (array[i] == uniqueArray[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                uniqueArray[index] = array[i];
                index++;
            }
        }
        int[] trimmedArray = new int[index];
        System.arraycopy(uniqueArray, 0, trimmedArray, 0, index);
        return trimmedArray;
    }
    
    
    public int[] getMissingValues() {
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        int missingCount = max - min - array.length + 1;
        int[] missingValues = new int[missingCount];
        int index = 0;
        for (int i = min; i <= max; i++) {
            boolean isMissing = true;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == i) {
                    isMissing = false;
                    break;
                }
            }
            if (isMissing) {
                missingValues[index] = i;
                index++;
            }
        }
        return missingValues;
    }
    
   
    public int[] fillMissingValues(int k) {
        int[] filledArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            filledArray[i] = array[i];
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (filledArray[i] == -1) {
                int nextValue = array[i + 1];
                for (int j = 0; j < k; j++) {
                    filledArray[i + j] = nextValue;
                    nextValue++;
                }
                i += k;
            }
        }
        return filledArray;
    }

}
