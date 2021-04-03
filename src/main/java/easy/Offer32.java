package easy;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2020/10/01  20:06
 */
public class Offer32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        travel(root,list,0);
        return list;
    }

    private void travel(TreeNode root,List<List<Integer>> list,int depth){
        if(root != null){
            if(list.size() <= depth){
                list.add(new LinkedList<>());
            }
            list.get(depth).add(root.val);
            travel(root.left,list,depth + 1);
            travel(root.right,list,depth + 1);
        }
    }
}
