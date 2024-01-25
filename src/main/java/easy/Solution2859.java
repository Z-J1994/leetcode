package easy;

import java.util.List;

/**
 * @author zhangjun
 * @since 2024/1/25 12:40
 */
public class Solution2859 {

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0,index = 0;
        for(int n : nums){
            if(Integer.bitCount(index++) == k){
                sum += n;
            }
        }
        return sum;
    }

}
