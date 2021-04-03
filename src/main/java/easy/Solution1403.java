package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjun
 * @version 2020/09/30  21:10
 */
public class Solution1403 {
    public List<Integer> minSubsequence(int[] nums) {
        int length = nums.length;
        quickSort(nums,0,length - 1);
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i = length - 1;i >= 0;i--){
            sum += nums[i];
        }
        int t = 0;
        for(int i = length - 1;i >= 0;i--){
            t += nums[i];
            list.add(nums[i]);
            if((t << 1) > sum){
                return list;
            }
        }

        return null;
    }

    private void quickSort(int [] nums,int lo,int hi){
        if(lo < hi){
            int p = partition(nums,lo,hi);
            quickSort(nums, lo, p - 1);
            quickSort(nums, p + 1, hi);
        }
    }

    private int partition(int [] nums,int lo,int hi){
        int p = nums[hi];
        int i = lo - 1;
        int j = hi;
        while(i < j){
            while(nums[++i] < p);
            while(i < j && nums[--j] > p);
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        int t = nums[hi];
        nums[hi] = nums[i];
        nums[i] = t;
        return i;
    }
}
