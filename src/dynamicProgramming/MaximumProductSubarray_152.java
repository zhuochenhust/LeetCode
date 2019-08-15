package dynamicProgramming;

public class MaximumProductSubarray_152 {
	// 方法1：传统最典型的dp
	// 时间复杂度：O(n), 空间复杂度：O(n)
	public int maxProduct_1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        int max = nums[0];
        
        // 构建dp数组，
        // 最大乘积有可能是最大的乘以当前，也可能是最小的(负最多的)乘以当前，所以需要两个dp数组记录最大和最小
        int[] maxhere = new int[n];
        int[] minhere = new int[n];
        
        // 初始化dp数组
        maxhere[0] = minhere[0] = nums[0];
        
        // 转移方程
        for (int i = 1; i < n; i ++) {
            maxhere[i] = Math.max(nums[i], Math.max(maxhere[i - 1] * nums[i], minhere[i - 1] * nums[i]));
            minhere[i] = Math.min(nums[i], Math.min(maxhere[i - 1] * nums[i], minhere[i - 1] * nums[i]));
            // maxhere 和 minhere都是当前位置数的最大最小乘积，而整个原始数组的最大乘积需要另一个值max来记录
            max = Math.max(max, maxhere[i]);
        }
        return max;
    }
	
	// 方法2：改良的dp, 深入理解递归的核心本质
	// 舍弃数组，时间复杂度O(n), 空间复杂度O(1)
	public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;
            
        // 初始化
        int max = nums[0];
        int maxhere = nums[0];
        int minhere = nums[0];
        
        // 转移方程
        for (int i = 1; i < n; i ++) {
            int maxpre = maxhere, minpre = minhere;
            maxhere = Math.max(Math.max(maxpre * nums[i], minpre * nums[i]), nums[i]);
            minhere = Math.min(Math.min(maxpre * nums[i], minpre * nums[i]), nums[i]);
            max = Math.max(max, maxhere);
        }
        return max;
    }
}
