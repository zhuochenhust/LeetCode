package classicQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_015 {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 和前面一个一样的话就跳到下一个
            if (nums[i] > 0) break;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) { // 和前面一个一样的话就跳到下一个
                    j ++; // 这里别忘了j++
                    continue;
                }
                if (nums[i] + nums[j] > 0) break;
                if (nums[i] + nums[j] + nums[k] < 0) {
                    j ++;
                    continue;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k --;
                    continue;
                } else {
                    List<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[i]);
                    triplets.add(nums[j]);
                    triplets.add(nums[k]);
                    result.add(triplets);
                    j ++;
                    k --;
                }
            }
        }
        return result;
    }

}
