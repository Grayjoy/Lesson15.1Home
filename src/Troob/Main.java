package Troob;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private static List<String> arrayStrins;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        readFile();
        addNewWordOrChangeOld(input(), wordBreakdown());
    }
    public static String input() {
        System.out.println("Введите слово");
        String scr = scanner.nextLine();
        return scr;
    }
    public static String[] wordBreakdown() {
        StringBuilder sb = new StringBuilder();
        System.out.println(arrayStrins);

        for (String line : arrayStrins) {
            sb.append(line);
        }

        String text = sb.toString().toLowerCase();
        String[] words = text.split("\\W+");
        return words;
    }

    public static void addNewWordOrChangeOld(String scr, String[] words) {

        HashMap<String, Integer> wordToCount = new HashMap<>();

        for (String word : words) {
            if (!wordToCount.containsKey(word)) {
                wordToCount.put(word, 0);
            }
            wordToCount.put(word, wordToCount.get(word) + 1);
        }
        if (wordToCount.containsKey(scr)) {
            System.out.println("Это старое слово, предыдущее значение: " + scr + " " + wordToCount.get(scr));
            wordToCount.put(scr, wordToCount.get(scr) + 1);
            System.out.println("Новое значение: " + scr + " " + wordToCount.get(scr));
        }
        if (!wordToCount.containsKey(scr)) {
            wordToCount.put(scr, 1);
            System.out.println("Это новое слово: " + scr + " " + wordToCount.get(scr));
        }
        System.out.println("\nСписок всех слов ");
        for (String word : wordToCount.keySet()) {
            System.out.println(word + " " + wordToCount.get(word));
        }
    }
    private static void readFile() {
        arrayStrins = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("text.txt"))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                arrayStrins.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
