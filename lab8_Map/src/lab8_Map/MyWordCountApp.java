package lab8_Map;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

public class MyWordCountApp {
    public static final String fileName = "D:\\lab8\\lab8_Map\\data\\fit.txt";
    private Map<String, Integer> map = new HashMap<>();

    public void loadData() {
      try {
    	  Scanner input = new Scanner(new File(fileName));
    	  while(input.hasNext()) {
    		  String word = input.next();
    		  map.put(word, map.getOrDefault(word, 0)+1);
    	  }
    	  input.close();
    		  
    	  }
      catch(FileNotFoundException e) {
    	  e.printStackTrace();
      }
      
       }

    public int countDistinct() {
    	return map.size();
    }
      
    

    public void printWordCounts() {
    	for(Map.Entry<String, Integer> entry : map.entrySet()) {
    		System.out.println(entry.getKey()+"-"+entry.getValue());
    		
    	}
    	
    }
     

    public void printWordCountsAlphabet() {
    	Map<String, Integer> sortedMap = new TreeMap<>() ;
    		for(Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
        		System.out.println(entry.getKey()+"-"+entry.getValue());
    		
    	}
       
       
    }

    public static void main(String[] args) {
        MyWordCountApp wordCounter = new MyWordCountApp();
        wordCounter.loadData();
        System.out.println("Number of distinct tokens: " + wordCounter.countDistinct());
        System.out.println("\nWord counts:");
        wordCounter.printWordCounts();
        System.out.println("\nWord counts in alphabetical order:");
        wordCounter.printWordCountsAlphabet();
    }
}



