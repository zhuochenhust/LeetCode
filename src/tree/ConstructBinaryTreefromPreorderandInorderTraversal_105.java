package tree;

import java.util.Arrays;

import org.junit.Test;

/** 
 * Problem: Given preorder and inorder traversal of a tree, construct the binary tree.
 * Problem link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 **/

public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder == null || inorder.length == 0 || preorder == null || preorder.length == 0)
			return null;
		// 1. 前序遍历数组的第一个值必然为root的值
		int rootVal = preorder[0];
		TreeNode tree = new TreeNode(rootVal);
		// 2. 不论中序还是后序，都是先左子树，中序数组中root左边的子数组就是中序的左子树组，同样也可得到后序左子数组，自然想到递归
		int inorderrootPosition = getPosition(inorder, rootVal);		
		int[] leftinorder = Arrays.copyOfRange(inorder, 0, inorderrootPosition);
		int[] leftpreorder = Arrays.copyOfRange(preorder, 1, inorderrootPosition + 1);
		int[] rightinorder = Arrays.copyOfRange(inorder, inorderrootPosition + 1, inorder.length);
		int[] rightpreorder = Arrays.copyOfRange(preorder, inorderrootPosition + 1, preorder.length);
		TreeNode leftTree = buildTree(leftpreorder, leftinorder);
		TreeNode rightTree = buildTree(rightpreorder, rightinorder);
		tree.left = leftTree;
		tree.right = rightTree;
		return tree;
	}
	
	public int getPosition(int[] input, int val) {
		for (int i = 0; i < input.length; i ++) {
			if (input[i] == val) {
				return i;
			}
		}
		return -1;
	}
	
	@Test
	public void testSolution() {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		TreeNode res = buildTree(preorder, inorder);
	}
}
