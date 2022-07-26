package medium;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @since 2022/7/25 13:02
 */
public class Solution919 {

    private static class CBTInserter {

        private final TreeNode root;

        private List<TreeNode> parentLevel;

        private int index = -1;

        public CBTInserter(TreeNode root) {
            this.root = root;
            parentLevel = new ArrayList<>();
            parentLevel.add(root);
            int size = 1;
            List<TreeNode> nextLevel = new ArrayList<>();
            while (size > 0) {
                TreeNode n = parentLevel.get(++index);
                if (n.left == null || n.right == null) {
                    return;
                }
                nextLevel.add(n.left);
                nextLevel.add(n.right);
                if (--size == 0) {
                    index = -1;
                    parentLevel = nextLevel;
                    size = parentLevel.size();
                    nextLevel = new ArrayList<>();
                }
            }
        }

        public int insert(int val) {
            if (index < parentLevel.size()) {
                TreeNode n = parentLevel.get(index);
                if (n.left == null) {
                    n.left = new TreeNode(val);
                } else {
                    n.right = new TreeNode(val);
                    index++;
                }
                return n.val;
            } else {
                List<TreeNode> nextLevel = new ArrayList<>();
                for (TreeNode n : parentLevel) {
                    nextLevel.add(n.left);
                    nextLevel.add(n.right);
                }
                parentLevel = nextLevel;
                index = 0;
                return insert(val);
            }
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
