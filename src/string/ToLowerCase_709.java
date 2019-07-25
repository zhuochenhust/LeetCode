package string;

public class ToLowerCase_709 {
	public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i ++) {
            char cur = str.charAt(i);
            if (cur >= 'A' && cur <= 'Z') {
                sb.append(charToLowerCase(cur));
            } else {
                sb.append(cur);
            }
        }
        return sb.toString();
    }
    
    public char charToLowerCase(char c) {
        // ascii table显示 小写的ascii码等于大写+32
        return (char)(c + 32);
    }
}
