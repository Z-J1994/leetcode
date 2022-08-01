package medium;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1161 {
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> level = new ArrayDeque<>();
        level.offer(root);
        int max = 0x80000000;
        int result = 1;
        int index = 0;
        int levelCount = 0;
        int size = 1;
        while(size > 0){
            TreeNode r = level.poll();
            levelCount += r.val;
            if(r.left != null){
                level.offer(r.left);
            }
            if(r.right != null){
                level.offer(r.right);
            }
            if(--size == 0){
                ++index;
                size = level.size();
                if(levelCount > max){
                    max = levelCount;
                    result = index;
                }
                levelCount = 0;
            }
        }
        return result;
    }
}
