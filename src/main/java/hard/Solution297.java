package hard;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2021/6/30
 */
public class Solution297 {
    private int index = 0;
    private int limit;
    private StringBuilder sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        serializeDFS(root);
        return sb.toString();
    }

    private void serializeDFS(TreeNode root){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        serializeDFS(root.left);
        serializeDFS(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] strs = data.split(",");
        limit = strs.length;
        return deserialize(strs);
    }

    private TreeNode deserialize(String [] strs){
        if(index >= limit || strs[index].equals("null")){
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strs[index++]));
        node.left = deserialize(strs);
        node.right = deserialize(strs);
        return node;
    }
}
