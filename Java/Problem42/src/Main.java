import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
@author: mces58

Problem 42
The nth term of the sequence of triangle numbers is given by Tn=n(n+1)/2; so the first ten triangle numbers are:
                                1,3,6,10,15,21,28,36,45,55,...
By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value.
For example, the word value for SKY is 19+11+25=55=10. If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?

Answer: 162
*/

public class Main {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {
            String line = br.readLine();
            if (line != null) {
                line = line.replace("\"", "");
                String[] wordArray = line.split(",");
                for (String word : wordArray) {
                    words.add(word);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        int triangleWordCount = 0;
        for (String word : words) {
            if (isTriangleNumber(calculateWordValue(word))) {
                triangleWordCount++;
            }
        }

        System.out.println("Number of triangle words: " + triangleWordCount);
    }
    
    public static boolean isTriangleNumber(int n) {
        double x = (-1 + Math.sqrt(1 + 8 * n)) / 2;
        return x == (int) x;
    }

    public static int calculateWordValue(String word) {
        int value = 0;
        for (char c : word.toCharArray()) {
            value += c - 'A' + 1;
        }
        return value;
    }
}
