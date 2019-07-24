package string;

public class ReverseWordsInAStringIII_557 {
	public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(reverse(str)).append(" ");
        }
        // 删除最后一个空格
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
    
    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
