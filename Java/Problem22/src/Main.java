import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
@author: mces58

Problem 22
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?

Answer: 871198282
*/

public class Main {
	public static void main(String[] args) {
		String filename = "names.txt";
		String[] names = null;

		// read the file and split the names
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = br.readLine();
			names = line.replace("\"", "").split(",");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// sort the names in alphabetical order
		Arrays.sort(names);

		// calculate the value of each letter
		Map<Character, Integer> dict = new HashMap<>();
		char[] alphabet = new char[26];

		for (int i = 0; i < 26; i++) {
			alphabet[i] = (char) ('A' + i);
		}

		String alphabetString = String.valueOf(alphabet);
		int letterValue = 1;

		for (char letter : alphabetString.toCharArray()) {
			dict.put(letter, letterValue);
			letterValue++;
		}

		// calculate the score for each name and add it to the total score
		int totalScore = 0;
		int index = 1;

		for (String name : names) {
			int nameScore = 0;
			for (char letter : name.toCharArray()) {
				nameScore += dict.get(letter);
			}
			totalScore += nameScore * index;
			index++;
		}
		System.out.println(totalScore);
	}
}
