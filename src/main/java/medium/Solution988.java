package medium;

import tree.TreeNode;
import utils.Parser;
import utils.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @since 2024/4/17 13:07
 */
public class Solution988 {
    public String smallestFromLeaf(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        int depth = dfs(root, null, list);
        char[] chars = new char[depth];
        int index = 0;
        while (!list.isEmpty()) {
            int min = 26;
            List<TreeNode> nl = null;
            for (TreeNode t : list) {
                if (t == null) {
                    return new String(chars, 0, index);
                }
                if (t.val < min) {
                    min = t.val;
                    nl = new ArrayList<>();
                    nl.add(t.left);
                } else if (t.val == min) {
                    assert nl != null;
                    nl.add(t.left);
                }
            }
            list = nl;
            chars[index++] = (char) ('a' + min);
        }
        return "";
    }

    public int dfs(TreeNode root, TreeNode parent, List<TreeNode> list) {
        if (root.left == null && root.right == null) {
            root.left = parent;
            list.add(root);
            return 1;
        }
        int t = 0;
        if(root.left != null){
            t = dfs(root.left, root, list);
        }
        if(root.right != null){
            t = Math.max(t, dfs(root.right, root, list));
        }
        root.left = parent;
        return t + 1;
    }

    public static void main(String[] args) {
        Solution988 s = new Solution988();
        System.out.println(s.smallestFromLeaf(TreeUtil.from(Parser.StringToIntegerArray("[0,1,2,3,4,3,4]"))).equals("dba"));
        System.out.println(s.smallestFromLeaf(TreeUtil.from(Parser.StringToIntegerArray("[25,1,3,1,3,0,2]"))).equals("adz"));
        System.out.println(s.smallestFromLeaf(TreeUtil.from(Parser.StringToIntegerArray("[2,2,1,null,1,0,null,0]"))).equals("abc"));
    }
}
