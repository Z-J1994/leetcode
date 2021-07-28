package easy;

import tree.TreeNode;

import java.util.*;

/**
 * @author zhangjun
 * @version 2021/7/28
 */
public class Solution863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> [] graph = new ArrayList[501];
        boolean [] marked = new boolean[501];
        graph[root.val] = new ArrayList<>();
        dfs(root,graph);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(target.val);
        for(int i = 1;i <= k;i++){
            ArrayList<Integer> current = new ArrayList<>();
            for(int x:result){
                if(!marked[x]){
                    for(int h : graph[x]){
                        if(!marked[h]){
                            current.add(h);
                        }
                    }
                    marked[x] = true;
                }
            }
            result = current;
        }
        return result;
    }

    private void dfs(TreeNode root,ArrayList<Integer> [] graph){
        if(root.left != null){
            graph[root.val].add(root.left.val);
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            graph[root.left.val] = list;
            dfs(root.left,graph);
        }

        if(root.right != null){
            graph[root.val].add(root.right.val);
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.val);
            graph[root.right.val] = list;
            dfs(root.right,graph);
        }
    }
}
