package Tree;

/** 
 * Problem: Given two binary trees, write a function to check if they are the same or not.
 * Problem link: https://leetcode.com/problems/same-tree/
 **/

public class SameTree_100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null) return p == q;
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
