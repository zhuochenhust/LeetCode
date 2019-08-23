package classicQuestion;

import java.util.Arrays;

public class ThreeSumClosest_016 {
	public int threeSumClosest(int[] nums, int target) {
        int closest = 0;
        if (nums == null) return closest;
        if (nums.length < 3) {
            for (int i = 0; i < nums.length; i++) {
                closest = closest + nums[i];
            }
            return closest;
        }
        Arrays.sort(nums);   
        closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i ++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum >target) {
                    k--;
                } else if (sum < target) {
                   j ++;
                } else {
                    return sum;
                }
            }
        }
        return closest;
    }

}
