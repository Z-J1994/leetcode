package easy;

/**
 * @author zhangjun
 * @version 2022/2/11
 */
public class Solution1984 {
    public int minimumDifference(int[] nums, int k) {
        quicksort(nums,0,nums.length - 1);
        int left = 0;
        int right = k - 1;
        int min = 0x7fffffff;
        int t;
        while(right < nums.length){
            if((t = nums[right++] - nums[left++]) < min){
                min = t;
            }
        }
        return min;
    }
    private void quicksort(int [] data,int lo,int hi){
        if(lo < hi){
            int p = random(data,lo,hi);
            quicksort(data,lo, p - 1);
            quicksort(data,p + 1,hi);
        }
    }

    private int random(int [] data,int lo,int hi){
        int mid = (lo + hi) >>> 1;
        int minValue = data[lo];
        int midValue = data[mid];
        int maxValue = data[hi];

        if(midValue > maxValue){
            int t = maxValue;
            maxValue = midValue;
            midValue = t;
        }
        if(minValue > maxValue){
            int t = maxValue;
            maxValue = minValue;
            minValue = t;
        }
        if(minValue > midValue){
            int t = midValue;
            midValue = minValue;
            minValue = t;
        }
        data[lo] = midValue;
        data[mid] = minValue;
        data[hi] = maxValue;
        return partition(data,lo,hi);
    }

    private int partition(int [] data,int lo,int hi){
        int v = data[lo];
        int i = lo;
        while(true){
            while(data[++i] < v);
            while(data[--hi] > v);
            if(i >= hi){
                break;
            }
            int t = data[i];
            data[i] = data[hi];
            data[hi] = t;
        }
        data[lo] = data[hi];
        data[hi] = v;
        return hi;
    }

    public static void main(String[] args) {
        Solution1984 s = new Solution1984();
        s.minimumDifference(new int[]{87063,61094,44530,21297,95857,93551,9918},6);
    }
}
