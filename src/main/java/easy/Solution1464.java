package easy;

/**
 * @author zhangjun
 * @version 2020/09/22  22:07
 */
public class Solution1464 {
    public int maxProduct(int[] nums) {
        int max1 = nums[0];
        int max2 = nums[1];
        if(max2 > max1){
            int t = max1;
            max1 = max2;
            max2 = t;
        }
        for(int i = 2;i < nums.length;i++){
            if(nums[i] >= max1){
                max2 = max1;
                max1 = nums[i];
            }else if(nums[i] > max2){
                max2 = nums[i];
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
}
