package dynamicProgramming;

import java.util.List;

public class Triangle_120 {
	public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 这里的dp数组是二维的，依照左图创建dp数组：
        int[][] dp = new int[n][];
        for (int i = 0; i < n; i ++) {
            dp[i] = new int[i + 1];
        }
        
        // 初始化dp数组
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i ++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0); // i行最左边只和i-1行的最左边毗邻
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i); // i行最右边只和i-1行最右边毗邻
        }
        
        // 转移状态方程
        for (int i = 1; i < n; i ++) {
            for (int j = 1; j < i; j ++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        
        // get answer
        int res = Integer.MAX_VALUE;
        for (int num : dp[n - 1]) {
            if (num < res) res = num;
        }
        return res;
    }
}
