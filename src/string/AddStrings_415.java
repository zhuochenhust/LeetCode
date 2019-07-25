package string;

public class AddStrings_415 {
	public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num2;
        if (num2 == null || num2.length() == 0) return num1;
        
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        while (i >= 0 || j >= 0) {
            char c1 = i >= 0 ? num1.charAt(i) : '0';
            char c2 = j >= 0 ? num2.charAt(j) : '0';
            cur += (c1- '0') + (c2 - '0');
            sb.append(cur % 10);
            cur /= 10;
            i --;
            j --;
        }
        if (cur > 0) {
            sb.append(cur);
        }
        return sb.reverse().toString();
    }
}
