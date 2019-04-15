package tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Problem: Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 * Problem link: https://leetcode.com/problems/unique-binary-search-trees-ii/
 * */

public class UniqueBinarySearchTreesII_095 {
	//遇到二叉树，优先考虑分治法递归，分治法和二叉树八字很和
	public List<TreeNode> generateTrees(int n) {
		return helper(1, n);
	}
	/*
	 *  这一题因为所有的节点包含1~n的连续数字。所以每一棵以k为root的树左子树范围为1~k-1，右子树范围为k+1～n。
	 *  用分治法可以很简单地得到结果。终结条件是当[1,k-1]和[k+1,n]空间为空时，返回只包含一个null元素的List。
	 * */
	public List<TreeNode> helper(int start, int end) {
		List<TreeNode> res = new ArrayList<>();
		//终止条件
		if (start > end) return res;
		//pick up a root
		for (int i = start; i <= end; i ++) {
			// all possible left subtrees if i is chosen to be a root
			List<TreeNode> left = helper(start, i - 1);
			// all possible right subtrees if i is chosen to be a root
			List<TreeNode> right = helper(i + 1, end);
			// connect left and right trees to the root i
			if (left.size() == 0 && right.size() == 0) {
                TreeNode root = new TreeNode(i);
                res.add(root);
            } else if (left.size() == 0) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i); //注意每一个root初始化一定要在循环内
                    root.right = r;
                    res.add(root);
                }
            } else if (right.size() == 0) {
                for (TreeNode l : left) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    res.add(root);
                }
            } else {
                for (TreeNode l : left) {
                    for (TreeNode r: right) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }     
		}		
		return res;
	}
	
	@Test
	public void solutionTest(){
		UniqueBinarySearchTreesII_095 ubst = new UniqueBinarySearchTreesII_095();
		List<TreeNode> res = ubst.generateTrees(3);
		for (int i = 0; i < res.size(); i ++) {
			System.out.println(res.get(i));
		}
	}
}
