package easy;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2022/3/7
 */
public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new StringBuilder());
        return result;
    }

    private final List<String> result = new ArrayList<>();

    private void dfs(TreeNode root, StringBuilder path) {
        int length = path.length();
        if (root.left == null && root.right == null) {
            path.append(root.val);
            result.add(path.toString());
            path.setLength(length);
            return;
        }
        path.append(root.val).append("->");
        if (root.left != null) {
            dfs(root.left, path);
        }
        if (root.right != null) {
            dfs(root.right, path);
        }
        path.setLength(length);
    }

}
