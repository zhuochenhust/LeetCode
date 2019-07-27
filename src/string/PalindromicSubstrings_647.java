package string;

public class PalindromicSubstrings_647 {
	public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        // 左指针=右指针 or 右指针 = 左指针 + 1
        for (int i = 0; i < s.length(); i ++) {
            count += countSubstrings(s, i, i) + countSubstrings(s, i, i + 1);
        }
        return count;
    }
    
	// 回文问题常用方法：左右两个指针往外扩散判断回文
    public int countSubstrings(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count ++;
            left --;
            right ++;
        }
        return count;
    }
}
