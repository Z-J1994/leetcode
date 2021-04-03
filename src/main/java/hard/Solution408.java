package hard;

import java.util.Arrays;

/**
 * @author zhangjun
 * @date 2021/2/3
 */
public class Solution408 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int length = nums.length - k + 1;
        double [] result = new double[length];
        int [] values = new int[k];
        for(int i = 0;i < k;i++){
            values[i] = nums[i];
        }

        int mid = (k - 1) / 2;
        if((k & 1) == 1){
            k -= 1;
//            insertion(values,k);
            Arrays.sort(values);
            result[0] += values[mid];
            for(int i = 1;i < length;i++){
                int index = binarySearch(values,k,nums[i - 1]);
                values[index] = nums[i + k];
                fix(values,k,index);
                result[i] += values[mid];
            }
        }else{
            k -= 1;
//            insertion(values,k);
            Arrays.sort(values);
            result[0] += ((values[mid] + values[mid + 1] * 1.0) / 2);
            for(int i = 1;i < length;i++){
                int index = binarySearch(values,k,nums[i - 1]);
                values[index] = nums[i + k];
                fix(values,k,index);
                result[i] += ((values[mid] + values[mid + 1] * 1.0) / 2);
            }
        }
        return result;
    }

    private int binarySearch(int [] values, int hi, int key){
        int lo = 0;
        while(lo <= hi){
            int mid = (hi - lo) / 2 + lo;
            if(values[mid] > key){
                hi = mid - 1;
            }else if(values[mid] < key){
                lo = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    private void insertion(int [] values,int hi){
        for(int i = 1,j;i <= hi;i++){
            int m = values[i];
            for(j = i;j > 0 && m < values[j - 1];j--){
                values[j] = values[j - 1];
            }
            values[j] = m;
        }
    }

    private void fix(int [] values,int hi,int index){
        int v = values[index];
        for(;index + 1 <= hi && values[index + 1] < v;index++){
            values[index] = values[index + 1];
        }
        for(;index > 0 && values[index - 1] > v;index--){
            values[index] = values[index - 1];
        }
        values[index] = v;
    }
}
