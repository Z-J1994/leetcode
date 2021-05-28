package medium;

/**
 * @author zhangjun
 * @version 2021/5/28
 */
public class Solution477 {
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0;i < 32;i++){
            int c = 0;
            for(int x : nums){
                c += (x >>> i) & 0x1;
            }
            sum += c * (n - c);
        }

        return sum;
    }
}
