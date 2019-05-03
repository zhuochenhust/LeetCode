package tree;

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
	
	/**
	 * 直接思路：
	 * 1. root.left是不是BST？
	 * 2. root.right是不是BST
	 * 3. root.left最大值是不是小于root.val
	 * 4. root.right最小值是不是大于root.val
	 * 很不好写，因为我们还得知道root.left最大值，root.right最小值是啥
	 * ------------------------------------------------------
	 * 换个思路：
	 * 对一个节点(root.val = V)来说，我先给他一个范围(min, max),看当前节点值是不是在范围之内
	 * 		如果否，则返回false
	 * 		如果是，则root.left的范围是[min, V - 1]; root.right范围是[V + 1, max]
	 * 用这样的方法来做，我们的返回值只需要boolean类型就可以了
	 * */
	public boolean helper(TreeNode root, Integer max, Integer min) {
		if (root == null) return true;
		if ((max != null && root.val >= max) || (min != null && root.val <= min)) return false;
		boolean left = helper(root.left, root.val, min);
		boolean right = helper(root.right, max, root.val);
		return left && right;
	}
	
	@Test
	public void solutionTest(){
		ValidateBinarySearchTree_098 vbst = new ValidateBinarySearchTree_098();
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
		boolean res = vbst.isValidBST(root);	
		System.out.println(res);
	}
}
