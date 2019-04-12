package tree;

import java.util.Arrays;

import org.junit.Test;

/** 
 * Problem: Given preorder and inorder traversal of a tree, construct the binary tree.
 * Problem link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 **/

public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {
	/*
	 * Solution 1: 每次递归用到的数组是原数组的一部分，每次创建新的数组，但是会浪费额外空间
	 * */
	public TreeNode buildTree_1(int[] preorder, int[] inorder) {
		if (inorder == null || inorder.length == 0 || preorder == null || preorder.length == 0)
			return null;
		// 1. 前序遍历数组的第一个值必然为root的值
		int rootVal = preorder[0];
		TreeNode tree = new TreeNode(rootVal);
		// 2. 中序数组中root左边的子数组就是中序的左子树组，同样也可得到前序左子数组，自然想到递归
		int inorderrootPosition = getPosition(inorder, rootVal);		
		int[] leftinorder = Arrays.copyOfRange(inorder, 0, inorderrootPosition);
		int[] leftpreorder = Arrays.copyOfRange(preorder, 1, inorderrootPosition + 1);
		int[] rightinorder = Arrays.copyOfRange(inorder, inorderrootPosition + 1, inorder.length);
		int[] rightpreorder = Arrays.copyOfRange(preorder, inorderrootPosition + 1, preorder.length);
		TreeNode leftTree = buildTree_1(leftpreorder, leftinorder);
		TreeNode rightTree = buildTree_1(rightpreorder, rightinorder);
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
	
	/* 
	 * Solution 2: 每次递归需要改变所要用到的数组时候，我们要考虑用参数start & end 而不是每次创建新的数组
	 * 任何时候遇到递归需要用某一部分数组的情况，优先考虑用参数标定所用到数组边界的方法，而不是创建数组
	 * */
	public TreeNode buildTree_2(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}
	
	public TreeNode helper(int[] preorder, int[] inorder, int pre_st, int pre_end, int in_st, int in_end) {
        if (pre_st > pre_end || in_st > in_end) return null;
        TreeNode root = new TreeNode(preorder[pre_st]);
        int i = in_st; // 这里注意千万别搞错用0而不是in_st
        while (i <= in_end) {
            if (inorder[i] == preorder[pre_st]) break;
            i ++;
        }
        root.left = helper(preorder, inorder, pre_st + 1, pre_st + i - in_st, in_st, i - 1);
        root.right = helper(preorder, inorder, pre_st + (i - in_st + 1), preorder.length - 1, i + 1, in_end);
        return root;
    }
	
	@Test
	public void testSolution() {
		int[] preorder = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		TreeNode res = buildTree_2(preorder, inorder);
	}
}
