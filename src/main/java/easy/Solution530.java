package easy;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author zhangjun
 * @version 2020/10/12  19:40
 */
public class Solution530 {
    public int getMinimumDifference(TreeNode root) {
        recursion(root);
        return min;
    }
    int min = Integer.MAX_VALUE;
    int last = -1;
    private void recursion(TreeNode root){
        if(root != null){

            recursion(root.left);
            int t = root.val - last;
            if(last >= 0){
               min =  Math.min(min,t);
            }
            last = root.val;
            recursion(root.right);
        }
    }
}
