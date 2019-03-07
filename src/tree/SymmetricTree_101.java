package tree;

/** 
 * Problem: Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * Problem link: https://leetcode.com/problems/symmetric-tree/
 **/

public class SymmetricTree_101 {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return helper(root.left, root.right);
	}
	public boolean helper(TreeNode p, TreeNode q) {
		if (p == null || q == null) return p == q;
		return p.val == q.val && helper(p.right, q.left) && helper(p.left, q.right);
	}
}
