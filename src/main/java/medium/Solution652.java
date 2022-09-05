package medium;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangjun
 * @since 2022/9/5 13:20
 */
public class Solution652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String,Wrapper> map = new HashMap<>();
        dfs(root,map);
        List<TreeNode> list = new ArrayList<>();
        for(Wrapper w : map.values()){
            if(w.count > 1){
                list.add(w.node);
            }
        }
        return list;
    }

    private String dfs(TreeNode root,Map<String,Wrapper> map){
        if(root == null){
            return null;
        }
        String s = String.valueOf(root.val);
        s = s + "," + dfs(root.left,map);
        s = s + "," + dfs(root.right,map);
        Wrapper w = map.computeIfAbsent(s,k -> new Wrapper());
        w.node = root;
        w.count++;
        return s;
    }

    private static class Wrapper{
        private TreeNode node;
        private int count = 0;
    }
}
