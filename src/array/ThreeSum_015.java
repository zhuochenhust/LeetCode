package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_015 {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) break;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j ++;
                    continue;
                }
                if (nums[i] + nums[j] > 0) break;
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k --;
                } else if (sum < 0) {
                    j ++;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j ++;
                    k --;
                }
            }
        }
        return res;
    }
}
