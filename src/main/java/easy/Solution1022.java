package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @since 2022/5/24 12:45
 */
public class Solution1022 {
    public int sumRootToLeaf(TreeNode root) {
        return preOrder(root,0);
    }

    private int preOrder(TreeNode root,int sum){
        sum = (sum << 1) | root.val;
        int t = 0;
        if(root.left != null){
            t = preOrder(root.left,sum);
        }
        if(root.right != null){
            t += preOrder(root.right,sum);
        }
        return  t == 0 ? sum : t;
    }
}
