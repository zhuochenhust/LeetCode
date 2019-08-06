package recursion;

public class PartitionToKEqualSumSubsets_698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        int subSum = sum / k;
        Arrays.sort(nums);
        int beginIndex = nums.length - 1;
        if (nums[beginIndex] > subSum) return false;
        // 如果有的数自己就等于sunSum了，那就可以自成一组，k也可以变成k-1
        while (beginIndex >= 0 && nums[beginIndex] == subSum) {
            beginIndex --;
            k --;
        }
        return partition(new int[k], nums, beginIndex, subSum);
    }
    
    public boolean partition(int[] subsets, int[] nums, int index, int target) {
        if (index < 0) { // 我们成功地把每一个数字放到了对应的subsets里面
            return true;
        }
        int selected = nums[index];
        for (int i = 0; i < subsets.length; i ++) { // 遍历我们有的所有组（数字的容器），试着将selected放进去
            if (subsets[i] + selected <= target) {
                subsets[i] += selected;
                if (partition(subsets, nums, index - 1, target)) { // 将selected放入subsets[i]之后剩下的还能被成功地partition，就返回true
                    return true;
                } else { // 否则回溯到selected放到subsets[i]之前的状态
                    subsets[i] -= selected;
                }
            }
        }
        // 遍历了所有组，都不能return true，就返回false
        return false;
    }
}
