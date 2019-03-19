package tree;

import java.util.LinkedList;
import java.util.List;

/** 
 * Problem: Given a binary tree, flatten it to a linked list in-place.
 * Problem link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 **/

public class FlattenBinaryTreetoLinkedList_114 {
	public void flatten(TreeNode root) {
		List<TreeNode> list = new LinkedList<>();
		dfs(list, root);
		for (int i = 0; i < list.size() - 1; i ++) {
			list.get(i).left = null;
			list.get(i).right = list.get(i + 1);
		}
	}
	
	// 递归法实现DFS
	public void dfs(List<TreeNode> list, TreeNode root) {
		if (root == null) return;
		list.add(root);
		dfs(list, root.left);
		dfs(list, root.right);
	}
}
