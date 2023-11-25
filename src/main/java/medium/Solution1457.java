package medium;

import tree.TreeNode;
import utils.Parser;
import utils.TreeUtil;

/**
 * @author zhangjun
 * @since 2023/11/25 13:10
 */
public class Solution1457 {

    private int bitmap = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        bitmap ^= 1 << root.val;
        if (root.left == null && root.right == null) {
            int r = (bitmap & (bitmap - 1)) == 0 ? 1 : 0;
            bitmap ^= 1 << root.val;
            return r;
        }
        int t = pseudoPalindromicPaths(root.left) + pseudoPalindromicPaths(root.right);
        bitmap ^= 1 << root.val;
        return t;
    }


    public static void main(String[] args) {
        Solution1457 s = new Solution1457();
//        System.out.println(s.pseudoPalindromicPaths(TreeUtil.from(Parser.StringToIntegerArray("[2,3,1,3,1,null,null,1,1,1,1]"))) == 0);
//        System.out.println(s.pseudoPalindromicPaths(TreeUtil.from(Parser.StringToIntegerArray("[2,1,1,1,3,null,null,null,null,null,1]"))) == 1);
//        System.out.println(s.pseudoPalindromicPaths(TreeUtil.from(Parser.StringToIntegerArray("[9]"))) == 1);
        System.out.println(s.pseudoPalindromicPaths(TreeUtil.from(Parser.StringToIntegerArray("[2,3,1,3,1,null,1]"))) == 2);

    }
}
