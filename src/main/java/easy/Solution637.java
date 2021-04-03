package easy;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2020/10/01  18:58
 */
public class Solution637 {
    private int depth;
    private long [] sum;
    private int [] count;
    public List<Double> averageOfLevels(TreeNode root) {
        depth(root,1);
        sum = new long[depth];
        count = new int[depth];
        travel(root,0);
        List<Double> list = new ArrayList<>();
        for(int i = 0;i < depth;i++){
            list.add((double)sum[i] / count[i]);
        }
        return list;
    }
    private void  depth(TreeNode root,int depth){
        if(root != null){
            if(depth > this.depth){
                this.depth = depth;
            }
            depth(root.left,depth + 1);
            depth(root.right,depth + 1);
        }
    }

    private void travel(TreeNode root,int depth){
        if(root != null){
            sum[depth] += root.val;
            count[depth]++;
            travel(root.left,depth + 1);
            travel(root.right,depth + 1);
        }
    }
}
