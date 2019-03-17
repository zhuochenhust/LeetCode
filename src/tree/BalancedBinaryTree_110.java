package tree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/** 
 * Problem: Given a binary tree, determine if it is height-balanced.
 * Problem link: https://leetcode.com/problems/balanced-binary-tree/
 **/

public class BalancedBinaryTree_110 {
	/**
	 * 直接法：遍历整棵树，看每个点是否符合要求
	 * 需要
	 * 	1. 实现BFS方法
	 * 	2. 实现获得树深度的方法
	 * */
	public boolean isBalanced_1(TreeNode root) {
		if (root == null) return true;
		// 广度优先遍历整个树看每个节点树否符合高度平衡二叉树的条件
		List<TreeNode> rootlist = BFS(root);
		for (TreeNode node : rootlist) {
			if (Math.abs(findDepth(node.left) - findDepth(node.right)) > 1) {
				return false;
			}
		}	
		return true;
	}
	
	// BFS
	public List<TreeNode> BFS(TreeNode root) {
		List<TreeNode> res = new ArrayList<>();
		if (root == null) return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i ++) {
				TreeNode head = queue.poll();
				res.add(head);
				if (head.left != null) {
					queue.offer(head.left);
				}
				if (head.right != null) {
					queue.offer(head.right);
				}
			}
		}
		return res;
	}
	
	// 找二叉树深度，递归
	public int findDepth(TreeNode root) {
		if (root == null) return 0;
		int leftDepth = findDepth(root.left);
		int rightDepth = findDepth(root.right);
		return  leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;		
	}
	
	/**
	 * 改进法：求深度的方法在求深度的同时能知道是否是高度平衡二叉树
	 * */
	public boolean isBalanced_2(TreeNode root) {
		if (root == null) return true;
		return (findHeight(root) != -1);
	}
	
	public int findHeight(TreeNode root) {
		if (root == null) return 0;
		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);
		/*
		 * return -1 代表不平衡
		 * 左子树和右子树但凡有一个返回-1（不平衡）则返回-1
		 * */
		if (Math.abs(leftHeight - rightHeight) > 1) return -1;
		if (leftHeight == -1 || rightHeight == -1) return -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	@Test
	public void solutionTest() {
		TreeNode root = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, 
				new TreeNode(15, null, null), new TreeNode(7, null, null)));
		assertEquals(true, isBalanced_1(root));
		assertEquals(true, isBalanced_2(root));
	}
}
