package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/** 
 * Problem: Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * Problem link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 **/

//思路和102是完全相似的，只是为了zigzag加入了一个boolean判定
public class BinaryTreeZigzagLevelOrderTraversal_103 {
	public List<List<Integer>> zigzaglevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		boolean normalOrder = true;
		while (!queue.isEmpty()) {
			List<Integer> cur = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i ++) {
				TreeNode head = queue.poll();
				cur.add(head.val);
				if (head.left != null) {
					queue.offer(head.left);
				}
				if (head.right != null) {
					queue.offer(head.right);
				}
			}
			if (normalOrder) {
				res.add(cur);
			} else {
				cur = reverse(cur);
				res.add(cur);
			}		
			normalOrder = !normalOrder;
		}	
		return res;
	}

	private List<Integer> reverse(List<Integer> cur) {
		List<Integer> res = new ArrayList<>();
		if (cur == null) return res;
		for (int i = cur.size() - 1; i >= 0; i --) {
			res.add(cur.get(i));
		}
		return res;
	}
	
	@Test
	public void solutionTest(){
		BinaryTreeZigzagLevelOrderTraversal_103 btzlo = new BinaryTreeZigzagLevelOrderTraversal_103();
		TreeNode root = new TreeNode(5,new TreeNode(3,new TreeNode(2, null, null), new TreeNode(4, null, null)), 
						new TreeNode(7, new TreeNode(6, null, null), 
						new TreeNode(8, new TreeNode(9, null, null), new TreeNode(10, null, null))));
		List<List<Integer>> res = btzlo.zigzaglevelOrder(root);
		for (int i = 0; i < res.size(); i ++) {
			List<Integer> cur = res.get(i);
			System.out.println("Current level is level " + i);
			for (int j = 0; j < cur.size(); j ++) {
				System.out.println(cur.get(j));
			}
		}
	}
}
