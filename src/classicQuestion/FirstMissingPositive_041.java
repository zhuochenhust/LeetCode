package classicQuestion;

public class FirstMissingPositive_041 {
	public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        // 拨乱反正的过程，[3, 4, -1, 1] --> [1, -1, 3, 4], 每个数到它应该在的位置去
        for (int i = 0; i < nums.length; i ++) {
            // 我们要找的数字一定是大于等于1小于等于数组长度的，太小了也就是1和0，太大了那就是像[7,8,9]这样的例子，let it be，没有拨乱反正的必要
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        // 拨乱反正后看每个位置上的数应该是那个位置index + 1，找到第一个不正确的那个，然后返回index + 1，也就是缺失的最小正整数了
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1; // nums = [1], should return 2，这是特殊情况，也就是一切都符合条件，强行找缺失的，那就应该是下一个整数
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
