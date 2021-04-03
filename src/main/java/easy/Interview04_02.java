package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2020/09/25  20:06
 */
public class Interview04_02 {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = recursion(nums,0,nums.length - 1);
        return root;
    }

    private TreeNode recursion(int[] nums,int lo,int hi){
        if(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            TreeNode x = new TreeNode(nums[mid]);
            x.left = recursion(nums,lo,mid - 1);
            x.right = recursion(nums,mid + 1,hi);
            return x;
        }
        return null;
    }
}
