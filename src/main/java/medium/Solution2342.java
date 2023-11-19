package medium;

import java.util.Arrays;

/**
 * @author zhangjun
 * @since 2023/11/18 12:59
 */
public class Solution2342 {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int [][] sorted = new int[n][2];
        for(int i = 0;i < n;i++){
            sorted[i][0] = bitSum(nums[i]);
            sorted[i][1] = nums[i];
        }
        Arrays.sort(sorted,(a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int max = -1;
        for(int i = n - 1,c = 1,p = -1;i >= 0;i--){
            if(sorted[i][0] == p){
                if(++c == 2 && sorted[i][1] + sorted[i + 1][1] > max){
                    max = sorted[i][1] + sorted[i + 1][1];
                }
            }else{
                p = sorted[i][0];
                c = 1;
            }
        }
        return max;
    }

    private int bitSum(int x){
        int sum = 0;
        while(x > 0){
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
