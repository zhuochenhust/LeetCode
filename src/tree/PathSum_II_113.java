package tree;

import java.util.ArrayList;
import java.util.List;

/** 
 * Problem: Given a binary tree and a sum, 
 * 			find all root-to-leaf paths where each path's sum equals the given sum.
 * Problem link: https://leetcode.com/problems/path-sum-ii/
 **/

public class PathSum_II_113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		List<Integer> cur = new ArrayList<>();
		helper(root, res, cur, 0, sum);
		return res;
	}
	
	public void helper(TreeNode root, List<List<Integer>> res, List<Integer> cur, int curSum, int sum) {
		if (root.left == null && root.right == null) {
			cur.add(root.val);
			curSum += root.val;
			if (curSum == sum) {
				// 这里老犯错，要注意不能直接res.add(cur)，因为cur一直是在变化的，这里只是加入的cur此时的内容
				res.add(new ArrayList<>(cur));
			}
			cur.remove(cur.size() - 1);
			curSum -= root.val;
		}
		cur.add(root.val);
		curSum += root.val;
		if (root.left != null) helper (root.left, res, cur, curSum, sum);
		if (root.right != null) helper (root.right, res, cur, curSum, sum);
		cur.remove(cur.size() - 1);
		curSum -= root.val;
	}
}
