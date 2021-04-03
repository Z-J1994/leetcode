package easy;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2020/09/18  20:22
 */
public class Solution1480 {
    public int[] runningSum(int[] nums) {
        for(int i = 1;i < nums.length;i++){
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int []a = {3,1,2,10,1};
        Solution1480 r = new Solution1480();
        System.out.println(Arrays.toString(r.runningSum(a)));
    }
}
