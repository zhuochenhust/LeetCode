package tree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/** 
 * Problem: Given a binary tree, find its minimum depth.
 * Problem link: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 **/

public class MinimumDepthofBinaryTree_111 {
	/**
	 * 直接思路：BFS
	 * 遍历每一层node，如果某层某个node左右都为null，那么可以直接返回此时的level
	 * */
	public int minDepth1(TreeNode root) {
		if (root == null) return 0;
		int level = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			level ++;
			List<TreeNode> cur = new ArrayList<>();
			for (int i = 0; i < size; i ++) {
				TreeNode head = queue.poll();
				cur.add(head);
				if (head.left != null) {
					queue.offer(head.left);
				}
				if (head.right != null) {
					queue.offer(head.right);
				}
			}
			for (TreeNode node : cur) {
				if (node.left == null && node.right == null) {
					return level;
				}
			}
		}
		return level;
	}
	
	/**
	 * BFS的方法有一些复杂，同样可以尝试用递归的方法
	 * */
	public int minDepth2(TreeNode root) {
		if (root == null) return 0;
		int left = minDepth2(root.left);
		int right = minDepth2(root.right);
		// 之所以有 left == 0 || right == 0 的判断，就是为了root2这种单边树情况
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
	}
	
	@Test
	public void testSolution() {
		TreeNode root1 = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, 
				new TreeNode(15, null, null), new TreeNode(7, null, null)));
		TreeNode root2 = new TreeNode(1, new TreeNode(2, null, null), null);
		TreeNode root3 = new TreeNode(1, new TreeNode(2, 
				new TreeNode(4, null, null), new TreeNode(5, null, null)), 
				new TreeNode(3, null, null));
		int ans1 = 2;
		int ans2 = 2;
		int ans3 = 2;
		int res1_1 = minDepth1(root1);
		int res1_2 = minDepth2(root1);
		int res2_1 = minDepth1(root2);
		int res2_2 = minDepth2(root2);
		int res3_1 = minDepth1(root3);
		int res3_2 = minDepth2(root3);
		assertEquals(ans1, res1_1);
		assertEquals(ans2, res2_1);
		assertEquals(ans3, res3_1);
		assertEquals(ans1, res1_2);
		assertEquals(ans2, res2_2);
		assertEquals(ans3, res3_2);
	}
}


