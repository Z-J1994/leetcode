package medium;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjun
 * @version 2021/7/29
 */
public class Solution1104 {
    public List<Integer> pathInZigZagTree(int label) {
        int length = 0;
        int sum = 1;
        while(sum <= label){
            sum <<= 1;
            length++;
        }

        Integer [] result = new Integer[length];
        result[length - 1] = label;
        if((length & 1) == 0){
            label = (sum >>> 1) + sum - 1 - label;
        }
        for(int i = length - 1;i >= 1;i--){
            sum >>>= 1;
            label >>>= 1;
            int t = label;
            if((i & 1) == 0){
                t = (sum >>> 1) + sum - 1 - label;
            }
            result[i - 1] = t;
        }

        return Arrays.asList(result);
    }
}
