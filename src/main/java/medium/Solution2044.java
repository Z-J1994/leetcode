package medium;

/**
 * @author zhangjun
 * @version 2022/3/15
 */
public class Solution2044 {
    public int countMaxOrSubsets(int[] nums) {
        dfs(nums,0,0);
        return count;
    }
    private int count = 0;
    private int max = 0;
    private void dfs(int [] nums,int index,int s){
        if(index == nums.length){
            if(s > max){
                max = s;
                count = 1;
            }else if(s == max){
                count++;
            }
            return;
        }
        dfs(nums,index + 1,s);
        dfs(nums,index + 1,s | nums[index]);
    }
}
