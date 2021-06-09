package main.java.easy;

/**
 * @author zhangjun
 * @version 2021/6/9
 */
public class Solution1827 {
    public int minOperations(int[] nums) {
        int count = 0;
        for(int i = 1,previous = nums[0],l = nums.length;i < l;i++){
            if(nums[i] <= previous){
                count += previous - nums[i] + 1;
                previous += 1;
            }else{
                previous = nums[i];
            }
        }
        return count;
    }
}
