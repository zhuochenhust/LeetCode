package tree;

/**
 * 1. 按照前面的分析， 这个题目的核心就是在于必须从叶节点开始处理，
 * 	    因为叶节点只有一个节点是邻居，就是他的父节点， 所以要让叶节点变成只有一个coin， 
 *    那就必须先把多余或者缺少的coin移到父节点，然后再处理，这样可以保证结果是最优的
 * 2. 可以写一个dfs函数返回要从叶节点给父节点多少个coin（如果叶节点的coin>1)， 
 *    或者是要从父节点给多少个coin到叶节点(如果叶节点的coin<1), 
 *    然后int v = left+right+node.val就是当前节点的coin个数, 
 *    那么v-1就是当前节点需要给父节点的个数（v-1可以是正数，也可以是负数，也可以是0）， 
 *    那么当前已经移动的步骤数就是Math.abs(left) + Math.abs(right)
 * 3. 这样一路递归到根节点，把每个节点需要移动的步数加起来就好   
 * */
public class DistributeCoinsInBinaryTree_979 {
	int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        ans += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;
    }
}
