package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_022 {
	// Using StringBuilder
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if (n <= 0) return res;
		StringBuilder sb = new StringBuilder();
		helper(res, sb, n, n);
		return res;
	}
	
	public void helper(List<String> res, StringBuilder sb, int open_left, int close_left) {
		if (open_left == 0 && close_left == 0) {
			res.add(sb.toString());
			return;
		}
		if (open_left > 0) {
			sb.append('(');
			helper(res, sb, open_left - 1, close_left);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (close_left > open_left) {
			sb.append(')');
			helper(res, sb, open_left, close_left - 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
	// Using String instead of StringBuilder
	public List<String> generateParenthesis_2(int n) {
		List<String> res = new ArrayList<>();
		if (n <= 0) return res;
		//StringBuilder sb = new StringBuilder();
		helper_2(res, "", n, n);
		return res;
	}
	
	public void helper_2(List<String> res, String s, int open_left, int close_left) {
		if (open_left == 0 && close_left == 0) {
			res.add(s);
			return;
		}
		if (open_left > 0) {
			// sb.append('(');
			helper_2(res, s + "(", open_left - 1, close_left);
			// sb.deleteCharAt(sb.length() - 1);
		}
		if (close_left > open_left) {
			// sb.append(')');
			helper_2(res, s + ")", open_left, close_left - 1);
			// sb.deleteCharAt(sb.length() - 1);
		}
	}
}
