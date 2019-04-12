package tree;

import java.util.Arrays;

/** 
 * Problem: Given inorder and postorder traversal of a tree, construct the binary tree.
 * Problem link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 **/

public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {
	/*
	 * Solution 1: 每次递归用到的数组是原数组的一部分，每次创建新的数组，但是会浪费额外空间
	 * */
	public TreeNode buildTree_1(int[] inorder, int[] postorder) {
		if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0)
			return null;
		// 1. 后序遍历数组的最后一个值必然为root的值
		int rootVal = postorder[postorder.length - 1];
		TreeNode tree = new TreeNode(rootVal);
		// 2. 不论中序还是后序，都是先左子树，中序数组中root左边的子数组就是中序的左子树组，同样也可得到后序左子数组，自然想到递归
		int inorderrootPosition = getPosition(inorder, rootVal);		
		int[] leftinorder = Arrays.copyOfRange(inorder, 0, inorderrootPosition);
		int[] leftpostorder = Arrays.copyOfRange(postorder, 0, inorderrootPosition);
		int[] rightinorder = Arrays.copyOfRange(inorder, inorderrootPosition + 1, inorder.length);
		int[] rightpostorder = Arrays.copyOfRange(postorder, inorderrootPosition, postorder.length - 1);
		TreeNode leftTree = buildTree_1(leftinorder, leftpostorder);
		TreeNode rightTree = buildTree_1(rightinorder, rightpostorder);
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
	public TreeNode buildTree_2(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    public TreeNode helper(int[] inorder, int[] postorder, int in_st, int in_end, int post_st, int post_end) {
        if (in_st > in_end || post_st > post_end) return null;
        TreeNode root = new TreeNode(postorder[post_end]);
        int i = in_st;
        while (i <= in_end) {
            if (inorder[i] == postorder[post_end]) break;
            i ++;
        }
        root.left = helper(inorder, postorder, in_st, i - 1, post_st, post_st + (i - in_st) - 1);
        root.right = helper(inorder, postorder, i + 1, in_end, post_st + (i - in_st), post_end - 1);
        return root;
    }
}