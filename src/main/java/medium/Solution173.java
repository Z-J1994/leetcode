package medium;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangjun
 * @date 2021/3/28
 */
public class Solution173 {
    class BSTIterator {
        private Deque<TreeNode> stack;
        private TreeNode x;
        public BSTIterator(TreeNode root) {
            x = root;
            stack = new LinkedList<>();
        }

        public int next() {

            while(x != null){
                stack.push(x);
                x = x.left;
            }
            x = stack.pop();
            int result = x.val;
            x = x.right;
            return result;
        }

        public boolean hasNext() {
            return !stack.isEmpty() || x != null;
        }
    }
}
