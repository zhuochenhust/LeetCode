package tree;

public class LowestCommonAncestorOfABinarySearchTree_235 {
	/**
	 * Recursion(Time complexity: O(N), Space complexity: O(log(N))~O(N))
	 * 1. Start traversing the tree from the root node
	 * 2. If both the nodes p and q are in the right subtree, then continue the search with right subtree starting step 1.
	 * 3. If both the nodes p and q are in the left subtree, then continue the search with left subtree starting step 1.
	 * 4. If both step 2 and step 3 are not true, this means we have found the node which is common to node p's and q's subtrees. 
	 * 	  and hence we return this common node as the LCA.
	 * */
	public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) return root;

        if (p.val > root.val && q.val > root.val) {
            // If both p and q are greater than parent
            return lowestCommonAncestor_1(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor_1(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }
	/**
	 * Iteration(Time complexity: O(N), Space complexity: O(1))
	 * 实际就是我们的目的只是找到split point，从它这里开始，p和q不属于同一子树
	 * 由于可能不需要遍历整个子树，所以复杂度为O(1)
	 * */
	public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) return root;
        
        // Start from the root node of the tree
        TreeNode node = root; 
        
        // Traverse the tree
        while (node != null) {
            if (node.val > p.val && node.val > q.val) {
                node = node.left;
            } else if (node.val < p.val && node.val < q.val) {
                node = node.right;
            } else {
                // split point found
                return node;
            }
        }
        return null;
    }
}
