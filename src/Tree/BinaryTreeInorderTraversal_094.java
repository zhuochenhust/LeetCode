package Tree;
// Problem link: https://leetcode.com/problems/unique-binary-search-trees/
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

public class BinaryTreeInorderTraversal_094 {
	/**
	 * 递归法
	 * 1. 中序遍历整颗以左节点为根的子树，将节点值存入res中
	 * 2. 将当前节点的值，存入res中
	 * 3. 中序遍历整颗以右节点为根的子树，将节点值存入res中
	 * */
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, res);
        return res;
    }
    public void helper(TreeNode root, List<Integer> res) { // 中序遍历并且依顺序将节点的值存入res中
        if (root == null) return;
        helper(root.left, res); // 中序遍历左子树
        res.add(root.val); // 根节点
        helper(root.right, res); // 中序遍历右子树
    }
    
    /**
	 * 迭代法
	 * 站在一个节点的主视角，提炼出一整套重复的动作。
	 * 1. 如果有左节点，去左节点。
	 * 2. 如果没有左节点，或者从左节点回来(不是从右节点回来)，往结果列表添加val
	 * 3. 如果有右节点，去右节点
	 * 4. 回到父节点，并且，从哪个节点回溯回来，就删除哪个节点。
	 * */
    public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		TreeNode cur = root;
		Stack<Boolean> fromLeft = new Stack<>();
		Stack<TreeNode> paraentNode = new Stack<>();
		boolean backFromRight = false;
		while (cur != null) {
			if (cur.left != null) {
				fromLeft.push(true);
				paraentNode.push(cur);
				cur = cur.left;
				continue;
			}
			if (!backFromRight) { // 从右节点回溯回来，不重复添加
				res.add(cur.val);
			} else {
				backFromRight = false;
			}
			if (cur.right != null) {
				fromLeft.push(false);
				paraentNode.push(cur);
				cur = cur.right;
				continue;
			}
			if (paraentNode.isEmpty()) break;
			cur = paraentNode.pop(); // 回到父节点
			boolean isFromLeft = fromLeft.pop();
			if (isFromLeft) {
				cur.left = null;
			} else {
				cur.right = null;
				backFromRight = true;
			}
		}
		return res;
    }
    
    /**
	 * 迭代法改良
	 * 既然迭代不能同时处理两条分支。就把二叉树全部分解成一根根左倾分支。
	 * 1. 一直往左分支走到底，经过的节点全部存入Stack
	 * 2. 从Stack里取最后一个出来，写入结果
	 * 3. 跑到这个节点的右节点
	 * 4. 重复步骤1~3
	 * */
    public List<Integer> inorderTraversal3(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		TreeNode cur = root;
		Stack<TreeNode> stack = new Stack<>();
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			res.add(cur.val);
			cur = cur.right;
		}
		return res;
    }
    
    @Test
	public void solutionTest(){
    	BinaryTreeInorderTraversal_094 btit = new BinaryTreeInorderTraversal_094();
    	// case 1, function 1
    	TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
    	List<Integer> res = btit.inorderTraversal(root);
    	System.out.println("Function 1 result is: ");
    	for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
    	// case 2, function 2
    	TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, new TreeNode(6, null, null)), new TreeNode(5, null, null)), new TreeNode(3, null, null));
    	List<Integer> res2 = btit.inorderTraversal2(root2);
    	System.out.println("Function 2 result is: ");
    	for (int i = 0; i < res2.size(); i++) {
			System.out.println(res2.get(i));
		}
    	// case 3, function 3
    	TreeNode root3 = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, new TreeNode(6, null, null)), new TreeNode(5, null, null)), new TreeNode(3, null, null));
    	List<Integer> res3 = btit.inorderTraversal3(root3);
    	System.out.println("Function 3 result is: ");
    	for (int i = 0; i < res3.size(); i++) {
			System.out.println(res3.get(i));
		}
    }
}


