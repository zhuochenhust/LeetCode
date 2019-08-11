package palindrome;

public class LongestPalindromicSubstring_005 {
	public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        String result = "";
        for (int i = 0; i < s.length(); i ++) {
            String str = palindrome(s, i, i);
            if (str.length() > result.length()) {
                result = str;
            }
            str = palindrome(s, i, i + 1);
            if (str.length() > result.length()) {
                result = str;
            }
        }
        return result;
    }
    
    
    // 以回文串为中心，由中心向左右扩散找最长回文子串
    public String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        return s.substring(left + 1, right);
    }
}
