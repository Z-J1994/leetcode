package easy;

/**
 * @author zhangjun
 * @date 2021/1/24
 */
public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        int l = nums.length;
        if (l <= 1){
            return l;
        }
        int max = 0;
        int count = 1;
        for(int i = 1,t = nums[0];i < l;i++){
            int k = nums[i];
            if(k <= t){
                max = count > max ? count : max;
                count = 0;
            }
            count++;
            t = k;
        }
        return max > count ? max : count;
    }
}
