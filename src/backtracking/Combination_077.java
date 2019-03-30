package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination_077 {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(n, k, res, cur, 1);
        return res;
    }
    public void helper(int n, int k, List<List<Integer>> res, List<Integer> cur, int start) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= n; i ++) {
            cur.add(i);
            helper(n, k, res, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
