package medium;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2021/7/14
 */
public class Solution1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int [] nums3 = Arrays.copyOf(nums1,length);
        Arrays.sort(nums3);

        int difference = 0;
        long sum = 0;
        for (int i = 0; i < length; i++) {
            int key = nums2[i];
            int t = Math.abs(nums1[i] - key);
            sum += t;
            int temp = Math.abs(t - near(nums3,key));
            if (temp > difference) {
                difference = temp;
            }
        }
        return (int)((sum - difference) % 1000000007);
    }

    private int near(int[] data, int key) {
        int lo = 0, hi = data.length - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (data[mid] > key) {
                hi = mid - 1;
            } else if (data[mid] < key) {
                lo = mid + 1;
            } else {
                return 0;
            }
        }
        if(hi == -1){
            return data[0] - key;
        }else if(lo == data.length){
            return key - data[data.length - 1];
        }
        return Math.min(key - data[hi] , data[lo] - key);
    }
}
