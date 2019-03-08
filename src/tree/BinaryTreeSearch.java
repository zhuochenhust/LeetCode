package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

public class BinaryTreeSearch {
	// Realizing DFS with stack
	public List<TreeNode> DFS(TreeNode root) {
		List<TreeNode> res = new ArrayList<>();
		if (root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			int size = stack.size();
			for (int i = 0; i < size; i ++) {
				TreeNode head = stack.pop();
				res.add(head);
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		return res;
	}
	
	// Realizing BFS with queue, same with problem 102: BinaryTreeOrderTraversal
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
	
	@Test
	public void testDFS() {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), 
						new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
		List<TreeNode> res = DFS(root);
		System.out.println("DFS result is: ");
		for (int i = 0; i < res.size(); i ++) {
			System.out.println(res.get(i).val);
		}	
	}
	
	@Test
	public void testBFS() {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), 
				new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
		List<TreeNode> res = BFS(root);
		System.out.println("BFS result is: ");
		for (int i = 0; i < res.size(); i ++) {
			System.out.println(res.get(i).val);
		}
	}
}
