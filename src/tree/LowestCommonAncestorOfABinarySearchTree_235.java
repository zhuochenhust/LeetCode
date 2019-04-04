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

        // Value of current node or parent node.
        int parentVal = root.val;

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestor_1(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor_1(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }
}
