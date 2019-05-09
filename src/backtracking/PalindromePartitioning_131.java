package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        List<String> cur = new ArrayList<>();
        helper(s, res, cur, 0);
        return res;
    }
    
    public void helper(String s, List<List<String>> res, List<String> cur, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < s.length(); i ++) {
            if (isPalindrome(s.substring(start, i + 1))) { // 这里是(start,i+1)不是(i, i+1)
                cur.add(s.substring(start, i + 1));
                helper(s, res, cur, i + 1); //这里注意是i+1不是start+1
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while(start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}
