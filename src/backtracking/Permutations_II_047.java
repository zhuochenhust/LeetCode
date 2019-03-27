package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations_II_047 {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        helper (nums, res, cur, new HashSet<Integer>());
        return res;
    }
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> cur, Set<Integer> set) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        int preUsed = nums[0] - 1;
        for (int i = 0; i < nums.length; i ++) {
            if (!set.contains(i) && nums[i] != preUsed) {
                cur.add(nums[i]);
                set.add(i);
                preUsed = nums[i];
                helper(nums, res, cur, set);
                set.remove(i);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
