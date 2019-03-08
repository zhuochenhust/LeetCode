package tree;

import org.junit.Test;

/** 
 * Problem: Given a binary tree, find its maximum depth.
 * Problem link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 **/

public class MaximumDepthofBinaryTree_104 {
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int res = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		return res;
	}
	
	@Test
	public void solutionTest() {
		// 在一个类中下面这行可以不要
		// MaximumDepthofBinaryTree_104 mdbt = new MaximumDepthofBinaryTree_104();
		TreeNode root = new TreeNode(1, new TreeNode(2, null, null), null);
		int res = maxDepth(root);
		System.out.println(res);
	}
}
