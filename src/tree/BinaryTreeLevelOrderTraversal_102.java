package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/** 
 * Problem: Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * Problem link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 **/

public class BinaryTreeLevelOrderTraversal_102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root); // 用add也可以，因为是queue是new的LinkedList
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i ++) {
				TreeNode head = queue.poll();
				level.add(head.val);
				if (head.left != null) {
					queue.offer(head.left);
				}
				if (head.right != null) {
					queue.offer(head.right);
				}
			}
			res.add(level);
		}	
		return res;
	}
	
	@Test
	public void solutionTest(){
		BinaryTreeLevelOrderTraversal_102 btot = new BinaryTreeLevelOrderTraversal_102();
		TreeNode root = new TreeNode(3,new TreeNode(9,null,null), new TreeNode(20, new TreeNode(15, null, null), 
				new TreeNode(7, null, null)));
		List<List<Integer>> res = btot.levelOrder(root);
		for (int i = 0; i < res.size(); i ++) {
			List<Integer> cur = res.get(i);
			System.out.println("Current level is level " + i);
			for (int j = 0; j < cur.size(); j ++) {
				System.out.println(cur.get(j));
			}
		}
	}
}
