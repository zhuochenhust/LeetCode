package classicQuestion;

import java.util.Stack;

public class LongestValidParentheses_032 {
	public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int leftMax = -1, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { // 遇到正括号
                stack.push(i);
            } else { // 遇到反括号
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    } else {
                        maxLen = Math.max(maxLen, i - leftMax);
                    }
                } else {
                    leftMax = i;
                }
            }
        }
        return maxLen;
    }
}
