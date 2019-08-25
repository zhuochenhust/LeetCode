package classicQuestion;

import java.util.Stack;

public class ValidParentheses_020 {
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else { // 只要String 中的每一个char没有遍历完，stack空的或者pop出来的char匹配不上，就返回false
                if (stack.isEmpty() || c != stack.pop()) return false; // 这里stack.isEmpty()的判断一定要写在前面，不然会有空栈异常
            }
        }
        return stack.isEmpty();
    }

}
