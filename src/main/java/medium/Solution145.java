package medium;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2020/09/29  15:40
 */
public class Solution145 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postTravel(root);
        return list;
    }

    private void postTravel(TreeNode root){
        if(root != null){
            postTravel(root.left);
            postTravel(root.right);
            list.add(root.val);
        }
    }
}
