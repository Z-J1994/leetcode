package medium;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author zhangjun
 * @version 2021/12/25
 */
public class Solution1609 {
    public boolean isEvenOddTree(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        if ((root.val & 1) == 0) {
            return false;
        }
        queue.add(root);
        for (int i = 1; !queue.isEmpty(); i++) {
            List<TreeNode> l = new ArrayList<>(queue.size() * 2);
            int previous;
            Predicate<Integer> p;
            Comparator<Integer> c;
            if ((i & 1) == 0) {
                previous = 0;
                c = (a, b) -> a - b;
                p = (t) -> (t & 1) == 1;
            } else {
                previous = 10000001;
                c = (a, b) -> b - a;
                p = (t) -> (t & 1) == 0;
            }
            for (TreeNode node : queue) {
                if (node.left != null) {
                    if (!p.test(node.left.val) || c.compare(node.left.val, previous) <= 0) {
                        return false;
                    }
                    l.add(node.left);
                    previous = node.left.val;
                }
                if (node.right != null) {
                    if (!p.test(node.right.val) || c.compare(node.right.val, previous) <= 0) {
                        return false;
                    }
                    l.add(node.right);
                    previous = node.right.val;
                }
            }
            queue = l;
        }
        return true;
    }
}
