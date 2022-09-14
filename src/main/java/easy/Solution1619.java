package easy;

import utils.Parser;

/**
 * @author zhangjun
 * @since 2022/9/14 13:01
 */
public class Solution1619 {
    public double trimMean(int[] arr) {
        int startIndex = (int)(arr.length * 0.05);
        int endIndex = arr.length - startIndex - 1;
        quickSelect(arr,0,arr.length - 1,startIndex);
        quickSelect(arr,startIndex,arr.length - 1,endIndex);
        int sum = 0;
        for(int i = startIndex;i <= endIndex;i++){
            sum += arr[i];
        }
        return (double)sum / (endIndex - startIndex+1);
    }

    private void quickSelect(int [] elements,int lo,int hi,int target){
        if(lo < hi){
            int p = getMid(elements,lo,hi);
            if(p > target){
                quickSelect(elements,lo,p - 1,target);
            }else if(p < target){
                quickSelect(elements,p + 1,hi,target);
            }
        }
    }

    private int getMid(int [] elements,int lo,int hi){
        int mid = (lo + hi) >>> 1;
        if(elements[hi] < elements[lo]){
            int t = elements[hi];
            elements[hi] = elements[lo];
            elements[lo] = t;
        }
        if(elements[hi] < elements[mid]){
            int t = elements[hi];
            elements[hi] = elements[mid];
            elements[mid] = t;
        }
        if(elements[mid] > elements[lo]){
            int t = elements[lo];
            elements[lo] = elements[mid];
            elements[mid] = t;
        }
        return partition(elements,lo,hi);
    }

    private int partition(int [] elements,int lo,int hi){
        int i = lo;
        int v = elements[i];
        while(true){
            while(elements[++i] < v);
            while(elements[--hi] > v);
            if(i >= hi){
                break;
            }
            int t = elements[i];
            elements[i] = elements[hi];
            elements[hi] = t;
        }
        elements[lo] = elements[hi];
        elements[hi] = v;
        return hi;
    }

    public static void main(String[] args) {
        Solution1619 s = new Solution1619();
        System.out.println(s.trimMean(Parser.StringToIntArray("[1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]")));
    }
}
