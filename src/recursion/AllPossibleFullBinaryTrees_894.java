package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tree.TreeNode;

public class AllPossibleFullBinaryTrees_894 {
	Map<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N == 0 || N % 2 == 0) return res;
        if (!map.containsKey(N)) {
            if (N == 1) {
                res.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int l = 0; l < N; l ++) {
                    int r = N - 1 - l;
                    for (TreeNode left: allPossibleFBT(l)) {
                        for (TreeNode right: allPossibleFBT(r)) {
                            TreeNode node = new TreeNode(0);
                            node.left = left;
                            node.right = right;
                            res.add(node);
                        }
                    }
                }
            }
            map.put(N, res);
        }
        return map.get(N);
    }
}
