package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph_133 {
	public Node cloneGraph(Node node) {
        // 1. 初始化判断
        if (node == null) return node;
        // 2. create HashMap
        HashMap<Node, Node> map = new HashMap<>();
        // 3. create a new node
        Node newNode = new Node(node.val, new ArrayList<Node>());
        map.put(node, newNode);
        // 4. 把new node对应的ori node的邻居也copy了
        clone(map, node, newNode);
        // 5. 返回clone后的node
        return newNode;
    }
    
    public void clone(HashMap<Node, Node> map, Node oriNode, Node clonedNode) {
        // 1. 遍历original node的neighbors
        // 2. 如果neighbors被copy过了，就把copied node加入copied neighbors list
        //    如果没有，就先clone然后再加入neighbors
        for (Node oriNeighbors : oriNode.neighbors) {
            if (map.containsKey(oriNeighbors)) {
                clonedNode.neighbors.add(map.get(oriNeighbors));
            } else {
                Node copiedNeighbors = new Node(oriNeighbors.val, new ArrayList<Node>());
                clonedNode.neighbors.add(copiedNeighbors);
                map.put(oriNeighbors, copiedNeighbors);
                clone(map, oriNeighbors, copiedNeighbors);   
            }
        }
    }
}
