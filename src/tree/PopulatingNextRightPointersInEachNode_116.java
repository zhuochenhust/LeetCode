package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode_116 {
	// 基本思路：BFS
	public Node connect_1(Node root) {
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
	
	// 进阶思路：递归
	public Node connect_2(Node root) {
        if (root == null) return null;
        root.next = null;
        connect(root.left, root.right);
        return root;
    }
    
    public void connect(Node left, Node right) {
        // 由于是perfect binary tree，所以如果left是空就说明这一层是空的不需要连接了
        if (left == null) return; 
        left.next = right;
        right.next = null;
        connect(left.left, left.right);
        connect(left.right, right.left);
        connect(right.left, right.right);
    }
}
