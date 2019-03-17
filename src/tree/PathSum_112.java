package tree;

import java.util.Stack;

/** 
 * Problem: Given a binary tree and a sum, determine if the tree has a root-to-leaf path 
 * 			such that adding up all the values along the path equals the given sum.
 * Problem link: https://leetcode.com/problems/path-sum/
 **/

public class PathSum_112 {
	/**
	 * 递归法
	 * */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
		// reach to a leaf
		if (root.left == null && root.right == null) {
			return sum - root.val == 0 ? true : false;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum -root.val);
	}
}
