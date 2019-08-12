package palindrome;

public class LongestPalindromicSubstring_005 {
	// 常规解法：
	public String longestPalindrome_1(String s) {
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
    
    // 动态规划解法：
    public String longestPalindrome_2(String s) {
        if (s == null) return "";
        int n = s.length();
        if (n == 0) return "";
        if (n == 1) return s;
        boolean[][] dp = new boolean[n][n];
        
        // 初始化dp
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                // i > j 是空串，回文，i == j，单字符串，回文
                // 其他情况就是字符串数组默认初始化的false
                if (i >= j) {
                    dp[i][j] = true;
                }
            }
        }
        
        // 构建dp的推导公式
        int maxLen = 1, left = 0, right = 0;
        for (int l = 1; l < n; l ++) {
            for (int i = 0; i + l < n; i ++) {
                int j = i + l;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j]) { // i～j是回文
                        if (l + 1 > maxLen) { // 当前回文字符串长度大于maxLen则更新maxLen和左右指针
                            maxLen = l + 1;
                            left = i;
                            right = j;
                        }
                    }
                    
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
