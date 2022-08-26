package easy;

/**
 * @author zhangjun
 * @version 2020/09/22  22:07
 */
public class Solution1464 {
    public int maxProduct(int[] nums) {
        int first;
        int second;
        if(nums[0] <= nums[1]){
            first = nums[1];
            second = nums[0];
        }else{
            first = nums[0];
            second = nums[1];
        }
        for(int i = 2;i < nums.length;i++){
            if(nums[i] >= first){
                second = first;
                first = nums[i];
            }else if(nums[i] > second){
                second = nums[i];
            }
        }
        return (first - 1) * (second - 1);
    }
}
