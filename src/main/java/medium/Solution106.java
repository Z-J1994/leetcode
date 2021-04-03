package medium;

import tree.TreeNode;

import java.util.HashMap;

/**
 * @author zhangjun
 * @date 2021/3/8
 */
public class Solution106 {
    int index;
    int[] inorder;
    int[] postorder;
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = inorder.length - 1;
        this.inorder = inorder;
        this.postorder = postorder;
        for(int i = 0;i <= index;i++){
            map.put(inorder[i],i);
        }
        return getChildren(0,index);
    }
    private TreeNode getChildren(int begin,int end){
        if(begin > end){
            return null;
        }
        int value = postorder[index--];
        int t = map.get(value);

        TreeNode node = new TreeNode(value);
        node.right = getChildren(t + 1,end);
        node.left = getChildren(begin,t - 1);
        return node;
    }

}
