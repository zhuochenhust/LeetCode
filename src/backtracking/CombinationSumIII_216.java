package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > 9 || n > 45) return res;
        List<Integer> cur = new ArrayList<>();
        helper(res, cur, k, n, 1);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> cur, int k, int n, int available) {
        if (n < 0 || k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = available; i <= n; i ++) {
            if (i > 9) break; // 很重要，不要忘记了
            cur.add(i);
            helper(res, cur, k - 1, n - i, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
