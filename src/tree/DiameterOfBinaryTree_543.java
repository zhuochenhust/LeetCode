package tree;

public class DiameterOfBinaryTree_543 {
	int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        getHeight(root);
        // 注意直径指的是最大边数而不是最长路径的node数，所以要减1
        return max - 1;
    }
    // DFS
    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
