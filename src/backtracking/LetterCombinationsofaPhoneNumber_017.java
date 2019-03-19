package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber_017 {
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0) return res;
		Map<Character, char[]> map = new HashMap<>();
		map.put('0', new char[]{});
		map.put('1', new char[]{});
		map.put('2', new char[]{'a', 'b', 'c'});
		map.put('3', new char[]{'d', 'e', 'f'});
		map.put('4', new char[]{'g', 'h', 'i'});
		map.put('5', new char[]{'j', 'k', 'l'});
		map.put('6', new char[]{'m', 'n', 'o'});
		map.put('7', new char[]{'p', 'q', 'r', 's'});
		map.put('8', new char[]{'t', 'u', 'v'});
		map.put('9', new char[]{'w', 'x', 'y', 'z'});
		StringBuilder sb = new StringBuilder();
		helper(digits, res, map, sb);
		return res;
	}
	
	public void helper(String digits, List<String> res, Map<Character, char[]> map, StringBuilder sb) {
		if (sb.length() == digits.length()) {
			res.add(sb.toString());
			return;
		}
		for (char c : map.get(digits.charAt(sb.length()))) {
			sb.append(c);
			helper(digits, res, map, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
