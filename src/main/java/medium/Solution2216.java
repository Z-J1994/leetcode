package medium;

import utils.Parser;

/**
 * @author zhangjun
 * @since 2023/11/21 13:39
 */
public class Solution2216 {
    public int minDeletion(int[] nums) {
        int count = 0;
        for(int i = 0;i + 1 < nums.length;i += 2){
            if(nums[i] == nums[i + 1]){
                count ++;
                i--;
            }
        }
        if((nums.length - count) % 2 == 1){
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2216 s = new Solution2216();
        System.out.println(s.minDeletion(Parser.StringToIntArray("[1,1,2,3,5]")));
        System.out.println(s.minDeletion(Parser.StringToIntArray("[1,1,2,2,3,3]")));
    }
}
