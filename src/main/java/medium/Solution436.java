package medium;

import utils.Parser;

import java.util.Arrays;

/**
 * @author zhangjun
 * @since 2022/5/20 12:48
 */
public class Solution436 {
    public int[] findRightInterval(int[][] intervals) {
        int [][] starts = new int[intervals.length][2];
        for(int i = 0;i < intervals.length;i++){
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }
        quickSort(starts,0,starts.length - 1);
        int [] result = new int[intervals.length];
        for(int i = 0;i < intervals.length;i++){
            result[i] = upperBound(starts,intervals[i][1]);
        }
        return result;
    }

    private int upperBound(int [][] data,int target){
        int lo = 0,hi = data.length;
        while(lo < hi){
            int mid = (lo + hi) >>> 1;
            if(data[mid][0] < target){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return hi == data.length ? -1 : data[hi][1];
    }

    private void quickSort(int [][] data,int lo,int hi){
        if(hi > lo){
            int p = getMid(data,lo,hi);
            quickSort(data,lo,p - 1);
            quickSort(data,p + 1,hi);
        }
    }

    private int getMid(int [][] data,int lo,int hi){
        int midIndex = (lo + hi) >>> 1;
        int [] minValue = data[lo];
        int [] midValue = data[midIndex];
        int [] maxValue = data[hi];

        if(midValue[0] < minValue[0]){
            int [] t = minValue;
            minValue = midValue;
            midValue = t;
        }
        if(maxValue[0] < minValue[0]){
            int [] t = minValue;
            minValue = maxValue;
            maxValue = t;
        }
        if(maxValue[0] < midValue[0]){
            int [] t = midValue;
            midValue = maxValue;
            maxValue = t;
        }

        data[lo] = midValue;
        data[midIndex] = minValue;
        data[hi] = maxValue;
        return partition(data,lo,hi);
    }

    private int partition(int [][] data,int lo,int hi){
        int i = lo;
        int [] v = data[lo];
        while(true){
            while(data[++i][0] < v[0]);
            while(data[--hi][0] > v[0]);
            if(i >= hi){
                break;
            }
            int [] t = data[i];
            data[i] = data[hi];
            data[hi] = t;
        }
        data[lo] = data[hi];
        data[hi] = v;
        return hi;
    }

    public static void main(String[] args) {
        Solution436 s = new Solution436();
        System.out.println(Arrays.toString(s.findRightInterval(Parser.stringToIntMatrix("[[1,4],[2,3],[3,4]]"))));
    }
}
