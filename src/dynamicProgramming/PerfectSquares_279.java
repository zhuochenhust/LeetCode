package dynamicProgramming;

import java.util.Arrays;

public class PerfectSquares_279 {
	public int numSquares(int n) {
        if (n == 1) return 1;
        
        // 构建dp数组
        int[] dp = new int[n + 1];
        
        // 初始化dp数组
        Arrays.fill(dp, Integer.MAX_VALUE); // 全部填充为最大值，为什么？看到转移方程就懂了
        dp[0] = 0; // 很关键，为什么dp[0] = 0? 看到转移方程就懂了
        
        // 转移方程
        // dp[0] = 0 
        // dp[1] = dp[0]+1 = 1
        // dp[2] = dp[1]+1 = 2
        // dp[3] = dp[2]+1 = 3
        // dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 } 
        //       = Min{ dp[3]+1, dp[0]+1 } 
        //       = 1				
        // dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 } 
        //       = Min{ dp[4]+1, dp[1]+1 } 
        //       = 2
        //                         .
        //                         .
        //                         .
        // dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 } 
        //        = Min{ dp[12]+1, dp[9]+1, dp[4]+1 } 
        //        = 2
        //                         .
        //                         .
        //                         .
        // dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= Math.sqrt(i); j ++) {
                dp[i] = Math.min(dp[i], (dp[i - (j * j)] + 1));;
            }
        }
        return dp[n];
    }
}
