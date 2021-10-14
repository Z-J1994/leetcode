package easy;

/**
 * @author zhangjun
 * @version 2021/10/14
 */
public class Offer_II_069 {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 1,hi = arr.length;
        while(lo < hi){
            int mid = (lo + hi) >>> 1;
            //左边上坡
            if(arr[mid - 1] < arr[mid]){
                lo = mid + 1;
            }
            // //右边上坡
            // else if(mid < arr.length - 1 && arr[mid + 1] < arr[mid]){
            //     hi = mid;
            // }
            // //边界
            else{
                hi = mid;
            }
        }
        return hi - 1;
    }
}
