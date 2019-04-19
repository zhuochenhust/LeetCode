package tree;

public class CountCompleteTreeNodes_222 {
	// 最直接的方法：无脑递归, 可是这丝毫没有用到Complete binary tree的性质，空间复杂度高
	public int countNodes_1(TreeNode root) {
        if (root == null) return 0;
        return countNodes_1(root.left) + countNodes_1(root.right) + 1;
    }
	
	
	////////////////////////////////////////////////////////////////////////////////////////
	// 改进：用到了complete binary tree的性质
	public int countNodes_2(TreeNode root) {
        if (root == null) {
            return 0;
        }
         
        int leftHeight = findLeftHeight(root);
        int rightHeight = findRightHeight(root);
        // tree是full的时候，node数量就是2^h - 1
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }
         
        return countNodes_2(root.left) + countNodes_2(root.right) + 1;
    }
     
    private int findLeftHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
         
        int height = 1;
         
        while (root.left != null) {
            height++;
            root = root.left;
        }
         
        return height;
    }
     
    private int findRightHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
         
        int height = 1;
         
        while (root.right != null) {
            height++;
            root = root.right;
        }
         
        return height;
    }
    /**
     * 时间复杂度： 
     * 递归要执行2h次（countNode(root.left) 和  countNode(root.right）)，
     * h为左高度，每次执行都要算一次高度用时h，
     * 所以时间复杂度是O(2h^2) = O(h^2)
     * */
}