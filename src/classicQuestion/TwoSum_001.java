package classicQuestion;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_001 {
	
	// 最好的解法就是用Map，因为求的是两个数，而3Sum，4Sum等就要一层层循环解了
	public int[] twoSum_1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int newTarget = target - nums[i];
            if (map.containsKey(newTarget) && i != map.get(newTarget)) {
                return new int[]{i, map.get(newTarget)};
            }
        }
        return null;
    }
	
	// 常规解法：i,j双指针
	public int[] twoSum_2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return null;
        for (int i = 0; i < nums.length - 1; i ++) {
            int j = i + 1;
            while (j < nums.length) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                } else {
                    j ++;
                }
            } 
        }
        return null;
    }
}
