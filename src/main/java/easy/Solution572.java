package easy;

import tree.TreeNode;

import static utils.TreeUtil.from;

public class Solution572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return root != null && (dfs(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot));
    }

    private boolean dfs(TreeNode root,TreeNode subRoot){
        if(root == subRoot){
            return true;
        }
        if(root == null || subRoot == null || root.val != subRoot.val){
            return false;
        }
        return dfs(root.left,subRoot.left) && dfs(root.right,subRoot.right);
    }

    public static void main(String[] args) {
        TreeNode r1 = from(new Integer[]{-111, -197, 136, null, -153, 8, 147, -155, -142, -40, 122, 139, 157, -175, null, -145, -140, -98, -24, 57, 124, 137, 146, 151, 169, -178, -161, -149, null, null, -128, -110, -95, -35, -5, 13, 113, null, 127, null, null, 143, null, 148, 154, 159, 189, -187, null, -165, -156, null, null, -138, -114, null, -106, null, -91, null, -32, -10, 0, 9, 49, 94, 119, null, 131, 141, 144, null, 150, 152, null, 158, 166, 177, 198, -195, -184, -168, -163, -160, null, null, null, -125, null, -108, -100, -92, -47, null, -28, -14, null, -1, 6, null, null, 21, 56, 88, 103, 117, 121, 130, 134, null, null, null, null, null, null, null, null, null, null, 164, 167, 170, 179, 190, 199, -196, -188, null, -181, -174, null, null, -162, null, null, -126, -123, null, null, -105, null, -93, null, -74, -45, -30, -25, -18, -12, -2, null, 4, 7, 20, 33, 53, null, 79, 90, 99, 104, 116, 118, 120, null, 129, null, 132, 135, null, null, null, null, null, 176, null, 183, null, 191, null, null, null, null, -193, null, null, null, null, -173, null, null, null, null, null, null, null, null, null, null, -77, -64, null, null, null, -29, -27, null, -23, -15, null, -11, -3, null, null, null, null, null, 16, null, 31, 39, 51, 54, 69, 85, null, null, 96, 102, null, 109, 115, null, null, null, null, null, null, null, null, 133, null, null, 171, null, 182, 186, null, 194, null, null, null, null, -87, null, -70, -55, null, null, null, null, null, -19, -17, null, null, null, null, null, null, null, 22, null, 34, 42, null, null, null, null, 58, 71, 83, 86, null, 97, 101, null, 107, 112, null, null, null, null, null, 172, 180, null, 185, null, 192, null, -89, -81, -73, -65, -59, -52, null, null, null, null, null, 26, null, 36, 41, 43, null, 60, null, 75, 80, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -82, null, null, null, -68, null, null, null, null, -50, null, null, null, 38, null, null, null, 46, null, 63, 72, 76, null, null, -84, null, null, -66, null, -48, 37, null, 44, null, 62, null, null, null, null, 78, null, null, -67, null, null, null, null, null, null, null, 61});
        TreeNode r2 = from(new Integer[]{-161, -165, -156, -168, -163, -160, null, -174, null, null, -162, null, null, null, -173});

        Solution572 s = new Solution572();
        System.out.println(s.isSubtree(r1, r2));
    }
}
