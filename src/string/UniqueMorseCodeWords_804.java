package string;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords_804 {
	public static final String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
			".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
			"--.." };

	public int uniqueMorseRepresentations(String[] words) {
		if (words == null || words.length == 0)
			return 0;
		Set<String> res = new HashSet<>();
		for (String word : words) {
			StringBuilder sb = new StringBuilder();
			for (char c : word.toCharArray()) {
				sb.append(morse[c - 'a']);
			}
			res.add(sb.toString());
		}
		return res.size();
	}
}
