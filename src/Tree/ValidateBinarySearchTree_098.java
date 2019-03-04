package Tree;

import org.junit.Test;

/**
 * Problem: Given a binary tree, determine if it is a valid binary search tree (BST).
 * Problem link: https://leetcode.com/problems/validate-binary-search-tree/
 * */

public class ValidateBinarySearchTree_098 {
	public boolean isValidBST(TreeNode root) {
		if (root == null) return true;
		return helper(root, null, null);
	}
	//很自然想到要有上下边界，但是用int的话无法确认初始值到底是什么，所以用了Integer
	public boolean helper(TreeNode root, Integer lower_limit, Integer upper_limit) {
		if (lower_limit != null && root.val <= lower_limit) return false;
		if (upper_limit != null && root.val >= upper_limit) return false;
		boolean left = (root.left != null) ? helper(root.left, lower_limit, root.val) : true;
		boolean right = (root.right != null) ? helper(root.right, root.val, upper_limit) : true;
		return (left && right);
	}
	
	@Test
	public void solutionTest(){
		ValidateBinarySearchTree_098 vbst = new ValidateBinarySearchTree_098();
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
		boolean res = vbst.isValidBST(root);	
		System.out.println(res);
	}
}
