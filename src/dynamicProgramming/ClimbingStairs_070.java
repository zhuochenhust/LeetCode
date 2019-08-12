package dynamicProgramming;

public class ClimbingStairs_070 {
	public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n];
        // 初始化
        dp[0] = 1;
        dp[1] = 2;
        // 转移方程
        for (int i = 2; i < n; i ++) {
            // 因为可以一次走一步或者两步
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
