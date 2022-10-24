package medium;

import utils.Parser;

/**
 * @author zhangjun
 * @version 2022/10/24
 */
public class Solution915 {
    public int partitionDisjoint(int[] nums) {
        int result = 0;
        for(int i = 1,maxBeforeMin= nums[0],max = maxBeforeMin;i < nums.length;i++){
            if(nums[i] < max){
                result = i;
                max = maxBeforeMin;
            }else if(nums[i] > maxBeforeMin){
                maxBeforeMin = nums[i];
            }
        }
        return result + 1;
    }

    public static void main(String[] args) {
        Solution915 s = new Solution915();
        System.out.println(s.partitionDisjoint(Parser.StringToIntArray("[29,33,6,4,42,0,10,22,62,16,46,75,100,67,70,74,87,69,73,88]")) == 11);
    }
}
