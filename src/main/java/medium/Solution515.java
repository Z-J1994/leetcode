package medium;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @since 2022/6/24 12:52
 */
public class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        return dfs(root,0,new ArrayList<>());
    }

    private List<Integer> dfs(TreeNode root, int depth, List<Integer> list){
        if(root == null){
            return list;
        }
        if(depth >= list.size()){
            list.add(root.val);
        }else if(root.val > list.get(depth)){
            list.set(depth,root.val);
        }
        depth++;
        dfs(root.left,depth,list);
        dfs(root.right,depth,list);
        return list;
    }
}
