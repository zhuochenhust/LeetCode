package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/** 
 * Problem: Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * Problem link: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * 就是102题的变种，倒过来罢了
 **/

public class BinaryTreeLevelOrderTraversal_II_107 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> cur = new ArrayList<>();
			for (int i =0; i < size; i ++) {
				TreeNode head = queue.poll();
				cur.add(head.val);
				if (head.left != null) {
					queue.add(head.left);
				}
				if (head.right != null) {
					queue.add(head.right);
				}
			}
			level ++;
			res.add(cur);
		}
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < level; i ++) {
			ans.add(res.get(level - i - 1));
		}
		return ans;
    }
	
	@Test
	public void solutionTest(){
		TreeNode root = new TreeNode(3,new TreeNode(9,null,null), new TreeNode(20, new TreeNode(15, null, null), 
				new TreeNode(7, null, null)));
		List<List<Integer>> res = levelOrderBottom(root);
		for (int i = 0; i < res.size(); i ++) {
			List<Integer> cur = res.get(i);
			System.out.println("Current level is level " + i);
			for (int j = 0; j < cur.size(); j ++) {
				System.out.println(cur.get(j));
			}
		}
	}
}
