package hard;

/**
 * @author zhangjun
 * @version 2021/5/22
 */
public class Solution810 {
    public boolean xorGame(int[] nums) {
        int length = nums.length;
        if(length % 2 == 0){
            return true;
        }
        int t = 0;
        for(int i = 0;i < length;i++){
            t ^= nums[i];
        }
        return t == 0;
    }
}
