package linkedlist;

import java.util.HashMap;

public class CopyListWithRandomPointer_138 {
	public Node copyRandomList(Node head) {
        // 1. 初始化判断
        if (head == null) return null;
        // 2. Create HashMap(key: old node, value: new node)
        HashMap<Node, Node> map = new HashMap<>();
        // 3. 完成克隆
        return clone(map, head);
    }
    
    public Node clone(HashMap<Node, Node> map, Node oriNode) {
        if (oriNode == null) return null; // 这句判断别忘记了
        if (map.containsKey(oriNode)) {
            return map.get(oriNode);
        } else {
            Node cloneNode = new Node(oriNode.val, null, null);
            map.put(oriNode, cloneNode);
            cloneNode.next = clone(map, oriNode.next);
            cloneNode.random = clone(map, oriNode.random);
            return cloneNode;
        }
    }
}
