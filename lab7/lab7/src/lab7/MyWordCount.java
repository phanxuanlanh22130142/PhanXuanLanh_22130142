package lab7;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class MyWordCount {
    public static final String fileName = "D:\\lab7\\lab7\\src\\lab7\\hamlet.txt";

    private List<String> words = new ArrayList<>();

    public MyWordCount() {
        try {
            this.words.addAll(Utils.loadWords(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<WordCount> getWordCounts() {
        List<WordCount> wordCounts = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            wordCounts.add(new WordCount(entry.getKey(), entry.getValue()));
        }

        return wordCounts;
    }

    public Set<String> getUniqueWords() {
        Set<String> uniqueWords = new HashSet<>(words);
        Set<String> repeatedWords = new HashSet<>();

        for (String word : words) {
            if (!uniqueWords.add(word)) {
                repeatedWords.add(word);
            }
        }

        uniqueWords.removeAll(repeatedWords);
        return uniqueWords;
    }

    public Set<String> getDistinctWords() {
        return new HashSet<>(words);
    }

    public Set<WordCount> exportWordCounts() {
        Set<WordCount> wordCounts = new TreeSet<>(Comparator.comparing(WordCount::getWord));
        wordCounts.addAll(getWordCounts());
        return wordCounts;
    }

    public Set<WordCount> exportWordCountsOrderByOccurrence() {
        Set<WordCount> wordCounts = new TreeSet<>(Comparator.comparingInt(WordCount::getCount).reversed());
        wordCounts.addAll(getWordCounts());
        return wordCounts;
    }

    public Set<String> filterWords(String pattern) {
        Set<String> filteredWords = new HashSet<>(words);
        filteredWords.removeIf(word -> word.startsWith(pattern));
        return filteredWords;
    }
    public static void main(String[] args) {
        String text = readTextFromFile(fileName);
        int wordCount = countWords(text);
        int characterCount = countCharacters(text);

        System.out.println("Word Count: " + wordCount);
        System.out.println("Character Count: " + characterCount);
    }

    public static String readTextFromFile(String fileName) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    public static int countWords(String text) {
        
        return 0;
    }

    public static int countCharacters(String text) {
        
        return text.length();
    }
}

