package easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2020/09/20  14:59
 */
public class Solution1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int length = nums.length;
        int count = 0;
        int [] target = new int[length];
        for(int i = 0;i < length;i++){
            int t = index[i];
            if(count > t){
                System.arraycopy(target,t,target,t + 1,count - t);
            }
            target[index[i]] = nums[i];
            count++;
        }
        return target;
    }
}
