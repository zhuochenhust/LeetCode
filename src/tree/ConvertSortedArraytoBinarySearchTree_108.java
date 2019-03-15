package tree;

import java.util.Arrays;

import org.junit.Test;

/** 
 * Problem: Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * Problem link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 **/

public class ConvertSortedArraytoBinarySearchTree_108 {
	public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        return root;
    }
	
	@Test
	public void solutionTest() {
		int[] nums = {-10, -3, 0, 5, 9};
		TreeNode res = sortedArrayToBST(nums);
	}
}
