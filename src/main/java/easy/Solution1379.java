package easy;

import tree.TreeNode;

public class Solution1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(cloned == null || cloned.val == target.val){
            return cloned;
        }
        TreeNode left = getTargetCopy(original,cloned.left,target);
        if(left != null){
            return left;
        }
        return getTargetCopy(original,cloned.right,target);
    }
}
