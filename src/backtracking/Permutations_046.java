package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations_046 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;
		List<Integer> cur = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		helper(nums, res, cur, set);
		return res;
	}

	private void helper(int[] nums, List<List<Integer>> res, List<Integer> cur, Set<Integer> set) {
		if (cur.size() == nums.length) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for (int i = 0; i < nums.length; i ++) {
			if (!set.contains(nums[i])) {
				cur.add(nums[i]);
				// set用来记录打头的数字
				set.add(nums[i]);
				helper(nums, res, cur, set);
				cur.remove(cur.size() - 1);
				set.remove(nums[i]);
			}
		}
	}
}
