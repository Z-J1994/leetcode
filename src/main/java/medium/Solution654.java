package medium;

public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums,0,nums.length - 1);
    }

    private TreeNode dfs(int [] nums,int start,int end){
        if(start > end){
            return null;
        }
        int pivot = getMaxIndex(nums,start,end);
        TreeNode root = new TreeNode(nums[pivot]);
        root.left = dfs(nums,start,pivot - 1);
        root.right = dfs(nums,pivot + 1,end);
        return root;
    }

    private int getMaxIndex(int [] nums,int start,int end){
        int maxIndex = start;
        while(++start <= end){
            if(nums[maxIndex] < nums[start]){
                maxIndex = start;
            }
        }
        return maxIndex;
    }
}
