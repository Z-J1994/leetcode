package medium;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjun
 * @version 2021/9/28
 */
public class Solution437 {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer,IntegerHolder> map = new HashMap<>();
        map.put(0,new IntegerHolder(1));
        dfs(root,0,targetSum,map);
        return count;
    }

    private int count = 0;

    private void dfs(TreeNode root, int sum, int targetSum, Map<Integer,IntegerHolder> map){
        if(root == null){
            return;
        }
        sum += root.val;
        IntegerHolder h = map.get(sum - targetSum);
        if(h != null){
            count += h.value;
        }
        h = map.get(sum);
        if(h == null){
            h =  new IntegerHolder(0);
            map.put(sum,h);
        }
        h.value++;

        dfs(root.left,sum,targetSum,map);
        dfs(root.right,sum,targetSum,map);

        h = map.get(sum);
        h.value--;
    }

    private static class IntegerHolder {
        private int value;
        private IntegerHolder(int value){
            this.value = value;
        }
    }
}
