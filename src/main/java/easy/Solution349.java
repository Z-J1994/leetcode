package easy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author zhangjun
 * @version 2020/09/27  21:12
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        int length = nums1.length;
        int [] result = new int[length];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0;

        int t = binarySearch(nums2,nums1[0]);
        if(t != -1){
            result[index++] = nums2[t];
        }

        for(int i = 1;i < length;i++){
            if(nums1[i] == nums1[i - 1]){
                continue;
            }
            t = binarySearch(nums2,nums1[i]);
            if(t != -1){
                result[index++] = nums2[t];
            }
        }
        return Arrays.copyOf(result,index);
    }

    private int binarySearch(int [] nums,int key){
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > key){
                hi = mid - 1;
            } else if(nums[mid] < key){
                lo = mid + 1;
            }else{
                return mid;
            }
        }
        return  -1;
    }

}
