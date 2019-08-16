package dynamicProgramming;

public class RangeSumQuery_303 {
	int[] dp;
    
	// 把dp的标准过程写在构造函数里面，会运行速度快一些
    public RangeSumQuery_303(int[] nums) { 
    	int n = nums.length;
        
        // 创建dp数组
        dp = new int[n];
        
        // 初始化dp数组
    	if (n > 0) { // 不可以忘记，否则空指针异常
            dp[0] = nums[0];
        }
        
        // 转移方程
        for (int k = 1; k < n; k ++) {
            dp[k] = dp[k - 1] + nums[k];
        }
    }
    
    public int sumRange(int i, int j) {   
        if (i == 0) return dp[j]; // 不可以忘记
        return dp[j] - dp[i - 1];     
    }  
}
