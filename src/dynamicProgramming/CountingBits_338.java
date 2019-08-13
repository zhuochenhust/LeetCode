package dynamicProgramming;

public class CountingBits_338 {
	/**
	 * Let look at the relation between x and x' = x / 2 
	 * x = (1001011101)2 = (605)10
	 * x' = (100101110)2 = (302)10
	 * x中1的个数等于x'中1的个数加上x mod 2的值
	 * */
	public int[] countBits(int num) {        
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i ++) {
            // 转移方程：P(x)=P(x/2)+(x mod 2)
            dp[i] = dp[i / 2] + (i % 2); 
            // 也可以写成dp[i] = dp[i >> 1] + (i & 1); x / 2 is x >> 1 and x % 2 is x & 1
        }
        return dp;
    }
}
