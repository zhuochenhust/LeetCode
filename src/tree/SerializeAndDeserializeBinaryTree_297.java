package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SerializeAndDeserializeBinaryTree_297 {
	public StringBuilder serializeHelper(TreeNode root, StringBuilder sb) {
		if (root == null) {
			return sb.append("null").append(',');
		} 
		sb.append(root.val).append(',');
		sb = serializeHelper(root.left, sb);
		sb = serializeHelper(root.right, sb);
		return sb;
	}
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(root, new StringBuilder()).toString();
    }
    
    public TreeNode deserializeHelper(List<String> list) {
    	if (list.get(0).equals("null")) {
    		list.remove(0);
    		return null;
    	}
    	TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
    	list.remove(0);
    	root.left = deserializeHelper(list);
    	root.right = deserializeHelper(list);
    	return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new ArrayList<>(Arrays.asList(data_array));
        return deserializeHelper(data_list);
    }
    
    @Test
    public void testSolution() {
    	TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null))
    					, new TreeNode(5, null, null));
    	String res = serialize(root);
    	System.out.println(res);
    }
}

//Your Codec object will be instantiated and called as such:
//Codec codec = new Codec();
//codec.deserialize(codec.serialize(root));

