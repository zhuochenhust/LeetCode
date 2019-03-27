package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence_060 {
	public String getPermutation(int n, int k) {
		StringBuilder sb = new StringBuilder();
		List<Integer> nums = new ArrayList<>();
		for (int i = 1; i <= n; i ++) {
			nums.add(i);
		}
		int index = k - 1;
		while (nums.size() > 0) {
			int i = index / factorial(n - 1);
			sb.append(nums.get(i));
			nums.remove(i);
			index = index % factorial(n - 1);
			n --;
		}
		return sb.toString();
	}
	
	public int factorial(int n) { //求阶乘
		if (n == 0) return 1;
		return n * factorial(n - 1);
	}
}
