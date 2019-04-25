package tree;

import java.util.HashMap;

public class PathSumIII_437 {
	public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1); // 为何一定要这一步? 因为如果curSum = target，必然count可以加1，所以要把curSum - target = 0考虑进去
        helper(root, sum, 0, preSum);
        return count;
    }
    
    // 最核心的在于，curSum-target存在于hashmap中，说明target就有了，因为curSum - (curSum - target) = target
	// key : the prefix sum, value : how many ways get to this prefix sum
    int count = 0;
    public void helper(TreeNode root, int target, int curSum, HashMap<Integer, Integer> preSum) {
        if (root == null) return;
        curSum += root.val;
        
        if (preSum.containsKey(curSum - target)) {
            count += preSum.get(curSum - target);
        }
        // preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1)，这一步要在上一个if之后而不能在之前，思考
        // 因为如果在if statement前面的话，有一种特殊情况：root = new TreeNode(1, null, null)，target = 0
        // 先put的话，那map里就有（1，0）这一对了，再判断的话 确实包含curSum - target = 1，那就无中生有了，因为只有一个root值为1，不可能有target = 0的路径
        // 所以在递归调用的开始，做判断，没毛病就增加count，因为递归会操作preSum，所以先判断后操作。
        preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1); 
        helper(root.left, target, curSum, preSum);
        helper(root.right, target, curSum, preSum);
        // 为什么有这一步？这就是backtracking
        // 因为backtracking永远是回退递归调用中改变的那个东西，每次调用递归结束要把它回退到调用前的状态
        // 这里的helper改变的是preSum这个hashmap，所以需要把它回退到改变前的状态。
        preSum.put(curSum, preSum.get(curSum) - 1); 
    }
}
