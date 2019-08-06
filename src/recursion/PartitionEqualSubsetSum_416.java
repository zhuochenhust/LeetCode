package recursion;

public class PartitionEqualSubsetSum_416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int subSum = sum / 2;
        Arrays.sort(nums);
        int beginIndex = nums.length - 1;
        if (nums[beginIndex] > subSum) return false;
        if (nums[beginIndex] == subSum) {
            return (sum - nums[beginIndex] == subSum);
        }
        return partition(new int[2], nums, beginIndex, subSum);
    }
    
    public boolean partition(int[] subsets, int[] nums, int index, int target) {
        if (index < 0) return true;
        int selected = nums[index];
        for (int i = 0; i < 2; i ++) {
            if (subsets[i] + selected <= target) {
                subsets[i] += selected;
                if (partition(subsets, nums, index - 1, target)) {
                    return true;
                } else {
                    subsets[i] -= selected;
                }
            }
        }
        return false;
    }
}
