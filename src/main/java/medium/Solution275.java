package medium;

/**
 * @author zhangjun
 * @version 2021/7/12
 */
public class Solution275 {
    public int hIndex(int[] citations) {
        int length = citations.length;
        int lo = 0,hi = length;
        int mid;
        while(lo < hi){
            mid = lo + (hi - lo) / 2;
            if(citations[mid] < length - mid){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return length - hi;
    }
}
