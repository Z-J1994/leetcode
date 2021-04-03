package medium;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2020/12/22/ 18:47
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        int mark = 0;
        LinkedList<TreeNode> t = new LinkedList<>();
        t.offer(root);
        while(t.size() > 0){
            LinkedList<TreeNode> t1 = new LinkedList<>();
            List<Integer> level = new ArrayList<>();
            while(!t.isEmpty()){
                TreeNode temp = t.poll();
                level.add(temp.val);
                if(temp.left != null){
                    t1.offer(temp.left);
                }
                if(temp.right != null){
                    t1.offer(temp.right);
                }
            }
            t = t1;
            if((mark & 0x1) == 1){
                Collections.reverse(level);
            }
            result.add(level);
            ++mark;
        }
        return result;
    }

}
