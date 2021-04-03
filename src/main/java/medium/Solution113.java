package medium;

import tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangjun
 * @version 2020/09/26  11:33
 */
public class Solution113 {
    int sum;
    List<List<Integer>> list = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        recursion(root,0);
        return list;
    }

    private void recursion(TreeNode root,int sum){
        if(root == null){
            return;
        }
        path.add(root.val);
        if(root.left == null && root.right == null && sum + root.val == this.sum){
            list.add(new LinkedList<>(path));
        }
        recursion(root.left,sum + root.val);
        recursion(root.right,sum + root.val);
        path.removeLast();

    }
}
