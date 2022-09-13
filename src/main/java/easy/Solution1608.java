package easy;

import utils.Parser;

import java.util.Arrays;

public class Solution1608 {
    public int specialArray(int[] nums) {
        if(nums[0] >= nums.length){
            return nums.length;
        }
        Arrays.sort(nums);
        int length = nums.length - 1;
        for(int i = 1;i < length;i++){
            if(nums[nums.length - i] >= i && nums[nums.length - i - 1] < i){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1608 s = new Solution1608();
//        System.out.println(s.specialArray(Parser.StringToIntArray("[0,4,3,0,4]")));
        System.out.println(s.specialArray(Parser.StringToIntArray("[3,5]")));
    }
}
