package lab8_Map;

import java.util.*;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextAnalyzer {
    private Map<String, ArrayList<Integer>> map = new HashMap<>();

    public void load(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    add(word, lineNumber);  
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(String word, int position) {
        ArrayList<Integer> positions = map.getOrDefault(word, new ArrayList<>());
        if (position % 3 == 0) {  
            position *= -1;  
        }
        positions.add(position);
        map.put(word, positions);
    }

    public void displayWords() {
        System.out.println("Word\tPosition(s)");
        System.out.println("=================");
        List<String> sortedWords = new ArrayList<>(map.keySet());
        Collections.sort(sortedWords);
        for (String word : sortedWords) {
            ArrayList<Integer> positions = map.get(word);
            System.out.print(word.toUpperCase() + "\t");
            for (int position : positions) {
                System.out.print(position + ", ");
            }
            System.out.println();
        }
    }

    public void displayText(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String mostFrequentWord() {
        String mostFrequentWord = "";
        int maxFrequency = 0;
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            int frequency = entry.getValue().size();
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostFrequentWord = entry.getKey();
            }
        }
        return mostFrequentWord;
    }

    
    public static void main(String[] args) {
        
        TextAnalyzer analyzer = new TextAnalyzer();
        
        analyzer.load("D:\\lab8\\lab8_Map\\data\\length.txt");
      
        analyzer.displayWords();
        
        analyzer.displayText("D:\\lab8\\lab8_Map\\data\\length.txt");
        
        System.out.println("Most Frequent Word: " + analyzer.mostFrequentWord());
    }
}

