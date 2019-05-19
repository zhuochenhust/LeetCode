package array;

public class MaximumSubarray_053 {
	/**
	 * 方法1:关键思路：例子：nums = [-1，2，3，-2，1]
	 * 1. 我们遍历这个数组的每一个元素，看看当前的元素num是自己本身比较大，还是加上前一个最大子串和之后比较大，这里用maxToCur记录基于当前数的最大子串和：
	 * 	  > maxToCur 初始值为nums[0], 也就是 maxToCur = -1，遍历到位置i = 1，也就是nums[1] = 2的时候，2本身比2+（-1）= 1大，
	 *    >那我干嘛还要和之前加在一起呢？所以maxToCur = 2。 一般地，maxToCur = Math.max(nums[i], nums[i] + maxToCur);
	 * 2. 用max记录我们的最终答案，max初始值为nums[0], 也就是max = -1，max记录之前我们遍历过程中最大的maxToCur，一般地，max = Math.max(max, maxToCue), 最后遍历完了就返回max。
	 * 3. 为什么这里不设置max 和 maxToCur的初始值为0呢？举例子，比如nums = [-1, -2]，那max和maxToCur永远都是0，但是实际答案应该是-1，所以初始值要设定为数组里面有的。
	 */
	public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxToCur = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            maxToCur = Math.max(nums[i], maxToCur + nums[i]);
            max = Math.max(max, maxToCur);
        }
        return max;
    }
	/**
	 * 方法2: 分治算法
	 * 1. 分而治之，mid = (low + high) / 2
	 * 2. 就三种可能性：
	 * 		1. 最大子串和在mid左边
	 * 		2. 最大子串和在mid右边
	 * 		3. 最大子串和是包含mid左边也包含右边的子串的和
	 * */
	public int maxSubArray_divide(int[] nums) {
		if (nums == null || nums.length == 0) {
            return 0;
        }
        int low = 0, high = nums.length - 1;
        return divide(nums, low, high);  
	}
	public int divide(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        if (low + 1 == high) {
            return Math.max((nums[low] + nums[high]), Math.max(nums[low], nums[high]));
        }
        int mid = (low + high) / 2;
        int left_max = divide(nums, low, mid - 1);
        int right_max = divide(nums, mid + 1, high);
        
        int max = nums[mid];
        int tmp = max;
        // 找到横跨mid的子数组的最大和
        for (int i = mid - 1; i >= low; i --) { // 向左走，找到往左加最大的和
            tmp += nums[i];
            max = Math.max(tmp, max);
        }
        tmp = max;
        for (int j = mid + 1; j <= high; j ++) { // 以往左加找到的最大的和为初始值，向右走，找往右加最大的和
            tmp += nums[j];
            max = Math.max(tmp, max);
        }
        return Math.max(max, Math.max(left_max, right_max));
    }
}
