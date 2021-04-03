package easy;

import tree.TreeNode;

/**
 * @author zhangjun
 * @version 2020/09/24  23:28
 */
public class Offer54 {
    int count = 0;
    int topK;
    public int kthLargest(TreeNode root, int k) {
        recursion(root,k);
        return topK;
    }

    private void recursion(TreeNode root, int k){
        if(root != null){
            recursion(root.right, k);
            count++;
            if(count == k){
               topK = root.val;
            }
            recursion(root.left,k);
        }
    }
}
