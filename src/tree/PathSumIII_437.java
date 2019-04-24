package tree;

import java.util.HashMap;

public class PathSumIII_437 {
	public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1); // 为何一定要这一步
        helper(root, sum, 0, preSum);
        return count;
    }
    
    // 最核心的在于，curSum-target存在于hashmap中，说明target就有了，因为curSum - (curSum - target) = target
    int count = 0;
    public void helper(TreeNode root, int target, int curSum, HashMap<Integer, Integer> preSum) {
        if (root == null) return;
        curSum += root.val;
        
        if (preSum.containsKey(curSum - target)) {
            count += preSum.get(curSum - target);
        }
        preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1); // 这一步要在上一个if之后而不能在之前，思考
        helper(root.left, target, curSum, preSum);
        helper(root.right, target, curSum, preSum);
        preSum.put(curSum, preSum.get(curSum) - 1); // 为什么有这一步？
    }
}
