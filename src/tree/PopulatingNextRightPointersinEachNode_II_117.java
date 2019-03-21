package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode_II_117 {
	// 和116一样的方法BFS
	public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	List<Node> cur = new ArrayList<>();
        	for (int i = 0; i < size; i ++) {
        		Node head = queue.poll();
        		cur.add(head);
        		if (head.left != null) {
        			queue.offer(head.left);
        		}
        		if (head.right != null) {
        			queue.offer(head.right);
        		}
        	}
        	for (int i = 0; i < cur.size(); i ++) {
        		if (i == cur.size() - 1) {
        			cur.get(i).next = null;
        			break;
        		}
        		cur.get(i).next = cur.get(i + 1);
        	}
        }
        return root;
    }
}
