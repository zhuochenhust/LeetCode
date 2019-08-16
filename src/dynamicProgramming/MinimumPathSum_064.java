package dynamicProgramming;

public class MinimumPathSum_064 {
	public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 构建dp数组
        int[][] dp = new int[m][n];
        
        // 初始化dp数组
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i ++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j ++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        // 转移方程
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                // 只能往下走和往右走，所以前一个必只能是正上或者正左
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        return dp[m - 1][n - 1];
    }
}
