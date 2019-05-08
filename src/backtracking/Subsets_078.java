package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets_078 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		helper(nums, res, cur, 0);
		return res;
	}

	private void helper(int[] nums, List<List<Integer>> res, List<Integer> cur, int start) {
		res.add(new ArrayList<>(cur));
		for (int i = start; i < nums.length; i ++) {
			cur.add(nums[i]);
			helper(nums, res, cur, i + 1);
			cur.remove(cur.size() - 1);
		}
	}
}
