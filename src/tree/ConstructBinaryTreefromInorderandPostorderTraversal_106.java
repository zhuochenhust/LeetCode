package tree;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/** 
 * Problem: Given inorder and postorder traversal of a tree, construct the binary tree.
 * Problem link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 **/

public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
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
		TreeNode leftTree = buildTree(leftinorder, leftpostorder);
		TreeNode rightTree = buildTree(rightinorder, rightpostorder);
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
}
