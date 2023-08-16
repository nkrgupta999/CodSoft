import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----Welcome in Word Counter Task-----");
        System.out.println("Enter '1' to input text, '2' to provide a file:");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        String text = "";
        if (choice == 1) {
            System.out.println("Enter the text:");
            text = scanner.nextLine();
        } else if (choice == 2) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            try {
                text = readFromFile(filePath);
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
                System.exit(1);
            }
        } else {
            System.err.println("Invalid choice. Please enter either '1' or '2'.");
            System.exit(1);
        }

        String[] words = text.split("\\s+|\\p{Punct}+");
        int totalCount = words.length;
        List<String> stopWords = Arrays.asList("the", "a", "an", "and", "in", "on", "is", "to"); // Add more stop words
                                                                                                 // if needed
        int uniqueCount = countUniqueWords(words, stopWords);
        Map<String, Integer> wordFrequency = calculateWordFrequency(words, stopWords);

        System.out.println("Total word count: " + totalCount);
        System.out.println("Number of unique words: " + uniqueCount);
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        scanner.close();
    }

    private static String readFromFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

    private static int countUniqueWords(String[] words, List<String> stopWords) {
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        uniqueWords.removeAll(stopWords);
        return uniqueWords.size();
    }

    private static Map<String, Integer> calculateWordFrequency(String[] words, List<String> stopWords) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            if (!stopWords.contains(word.toLowerCase())) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
        return wordFrequency;
    }
}
