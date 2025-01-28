// Tat Putjorn 672115024 //

import java.io.File;
import java.util.Scanner;

public class TextReader {

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        int totalCharCount = 0;
        int totalPalindrome = 0;
        int totalTokens = 0;
        int totalEmoticon = 0;
        int totalNewLine = 0;

        int longestTokenSize = 0;
        double sumTokenLengths = 0.0;

        try {
    
            File file = new File("D:\\coding\\Abstract\\Assignment_2\\input1.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                totalNewLine++;
                totalCharCount += line.length();

                String[] tokens = line.split("\\s+");
                for (String token : tokens) {
                    if (!token.isEmpty()) {
                        totalTokens++;
                        int length = token.length();
                        sumTokenLengths += length;

                        if (length > longestTokenSize) {
                            longestTokenSize = length;
                        }
    
                        if (isPalindrome(token)) {
                            totalPalindrome++;
                        }

                        if (isEmoticon(token)) {
                            totalEmoticon++;
                        }
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("File not found: D:\\coding\\Abstract\\Assignment_2\\input1.txt");
            return;
        }

        double averageSize = 0.0;
        if (totalTokens > 0) {
            averageSize = sumTokenLengths / totalTokens;
        }

        long endTime = System.nanoTime();
        double totalSeconds = (endTime - startTime) / 1_000_000_000.0;
        
        System.out.println();
        System.out.println("Program start:");
        System.out.println();
        System.out.println("Total # Character count: " + totalCharCount);
        System.out.println("Total # Palindrome found: " + totalPalindrome);
        System.out.println("Total Number of tokens: " + totalTokens);
        System.out.println("Total Number of emoticon: " + totalEmoticon);
        System.out.println("Total # of new line: " + totalNewLine);
        System.out.println("The longest and average token size token " + longestTokenSize + " " + String.format("%.1f", averageSize));
        System.out.println("Total time to execute this program " + String.format("%.1f", totalSeconds) + "secs");
        System.out.println();
        System.out.println("Program terminated properly!");
        System.out.println();

    }

    private static boolean isPalindrome(String word) {

        String lower = word.toLowerCase().replaceAll("[^a-z0-9]", "");
        if (lower.length() == 0) {
            return false;
        }
        String reverse = new StringBuilder(lower).reverse().toString();
        return lower.equals(reverse);
    }

    private static boolean isEmoticon(String token) {
        String t = token.toLowerCase();
        String[] emoticons = {":)", ":-)", ":(", ":-(", ":d", ":-d", "xd", "=d", ":'(", ":p", ":-p", ":o", ":-o"};
        for (String e : emoticons) {
            if (t.equals(e)) {
                return true;
            }
        }
        return false;
    }
}
