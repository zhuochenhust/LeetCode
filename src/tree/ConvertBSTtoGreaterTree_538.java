package tree;

public class ConvertBSTtoGreaterTree_538 {
	int sum = 0;
    // 这里用到BST特性：左边的一定比root值小，右边的一定比root值大
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right); // 右子树convert和当前root没关系，因为右边都比当前的大，不会需要加当前root的val
        sum += root.val; // root.right都比当前root值大，所以经过convert(root.right)以后的sum就是比当前root大的node的sum
        root.val = sum; // 更新当前root的sum
        convertBST(root.left);
        return root;
    }
}
