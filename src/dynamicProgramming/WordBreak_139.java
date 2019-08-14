package dynamicProgramming;

import java.util.List;

public class WordBreak_139 {
	// 方法1:动态规划，推荐方法！
	/**
     * Time complexity : O(n^2). Two loops are their to fill dp array.
     * Space complexity : O(n). Length of dp array is n+1.
     * */
	public boolean wordBreak_1(String s, List<String> wordDict) {
        //Set<String> wordDictSet=new HashSet(wordDict);
        int n = s.length();
        if (n == 0) return true;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        // i代表字符串长度
        for (int i = 1; i <= n; i ++) {
            for (int j = 0; j < i; j ++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
	
	// 方法2: 暴力递归(复杂度太高，会超时)
	/**
	 * Time complexity : O(n^n)。
	 * Consider the worst case where s = "aaaaaaaaaaaaaa" 
	 * and every prefix of ss is present in the dictionary of words, 
	 * then the recursion tree can grow upto n^n.
	 * 
	 * Space complexity : O(n). 
	 * The depth of the recursion tree can go upto nn
	 * */
	public boolean wordBreak_2(String s, List<String> wordDict) {
        return helper(s, wordDict, 0);
    }
    
    public boolean helper(String s, List<String> wordDict, int start) {
        // 退出条件
        if (start == s.length()) return true;
        // 递归
        for (int end = start + 1; end <= s.length(); end ++) {
            if (wordDict.contains(s.substring(start, end)) && helper(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }
    
    // 方法3: 备忘录递归，也就是自顶向下的动态规划
    /**
     * Time complexity : O(n^2)  Size of recursion tree can go up to n^2n 
     * Space complexity : O(n). The depth of recursion tree can go up to n. 
     * */
    public boolean wordBreak_3(String s, List<String> wordDict) {
        return helper(s, wordDict, 0, new Boolean[s.length()]);
    }
    
    public boolean helper(String s, List<String> wordDict, int start, Boolean[] memo) {
        // 退出条件
        if (start == s.length()) return true;
        // 备忘录
        if (memo[start] != null) { // 因为要和null比较，memo数组必须是封装类Boolean，这里需要注意
            return memo[start];
        }
        // 递归
        for (int end = start + 1; end <= s.length(); end ++) {
            if (wordDict.contains(s.substring(start, end)) && helper(s, wordDict, end, memo)) {
                return memo[start] = true;
                //return true;
            }
        }
        return memo[start] = false;
        //return false;
    }
}
