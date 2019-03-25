package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0) return res;
		List<Integer> cur = new ArrayList<>();
		Arrays.sort(candidates);
		helper(candidates, target, res, cur, 0);
		return res;
	}

	private void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> cur, int index) {
		if (target == 0) {
			res.add(new ArrayList<>(cur));
            return;
		}
		for (int i = index; i < candidates.length; i ++) {
			if (target < 0) {
				break;
			}
			cur.add(candidates[i]);
			helper(candidates, target - candidates[i], res, cur, i);
			cur.remove(cur.size() - 1);
		}
	}
}
