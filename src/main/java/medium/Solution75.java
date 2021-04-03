package medium;

/**
 * @author zhangjun
 * @version 2020/10/07  15:30
 */
public class Solution75 {
    public void sortColors(int[] nums) {
        int lessThan = 0;
        int greaterThan = nums.length - 1;
        for(int i = 0;i <= greaterThan;){
            if(nums[i] < 1){
                exchange(nums,lessThan++,i++);
            }else if(nums[i] > 1){
                exchange(nums,greaterThan--,i);
            }else{
                i++;
            }
        }
        int t = 5;
    }

    private void exchange(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
