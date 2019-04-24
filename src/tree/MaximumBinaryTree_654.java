package tree;

import org.junit.Test;
/**
 * 规则：
 * 1. nums中找到max作为root
 * 2. max左边的作为root.left
 * 3. max右边的作为root.right
 * */
public class MaximumBinaryTree_654 {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0 || nums == null) return null;
        return helper(nums, 0, nums.length - 1);
    }
    
    // 之所以设置l和r两个边界，就是为了避免数组本身的变化。数组可以是不变的，运用规则的范围变化就可以了
    public TreeNode helper(int[] nums, int l, int r) {
        if (l > r) return null;
        int max_i = findMaxIndex(nums, l, r);
        TreeNode root = new TreeNode(nums[max_i]);
        root.left = helper(nums, l, max_i - 1);
        root.right = helper(nums, max_i + 1, r);
        return root;
    }
    
    public int findMaxIndex(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i <= r; i ++) {
            if (nums[i] > nums[max_i]) {
                max_i = i;
            }
        }
        return max_i;
    }
    
    @Test
    public void testSolution() {
    	int[] nums = {3, 2, 1, 6, 0, 5};
    	TreeNode root = constructMaximumBinaryTree(nums);
    }
}
