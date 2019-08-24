package classicQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_018 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) { // 从这里开始和3Sum做法一模一样
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    if (l > j + 1 && nums[l] == nums[l - 1]) { // 这里去重复容易被忽略
                        l ++;
                        continue;
                    }
                    int newTraget = target - nums[i] - nums[j];
                    int sum = nums[l] + nums[r]; // 这个一定要在while循环里面定义！！！
                    if (sum > newTraget) {
                        r --;
                    } else if (sum < newTraget) {
                        l ++;
                    } else {
                        List<Integer> four = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        // four.add(nums[i]);
                        // four.add(nums[j]);
                        // four.add(nums[l]);
                        // four.add(nums[r]);
                        result.add(four);
                        l ++;
                        r --;
                    }
                }
            }
        }
        return result;
    }
}
