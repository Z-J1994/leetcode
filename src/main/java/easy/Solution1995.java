package easy;

/**
 * @author zhangjun
 * @version 2021/12/29
 */
public class Solution1995 {
    public int countQuadruplets(int[] nums) {
        int count = 0;
        for(int i = 3;i < nums.length;i++){
            int d = nums[i];
            for(int j = i - 1;j > 1;j--){
                int c = nums[j];
                for(int k = j - 1;k > 0;k--){
                    int b = nums[k];
                    for(int l = k - 1;l >= 0;l--){
                        if(nums[l] + b + c == d){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
