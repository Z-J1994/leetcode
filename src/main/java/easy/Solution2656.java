package easy;

/**
 * @author zhangjun
 * @since 2023/11/15 13:10
 */
public class Solution2656 {
    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for(int i : nums){
            if(i > max){
                max = i;
            }
        }
        return max * k + ((k * (k - 1)) >> 1);
    }
}
