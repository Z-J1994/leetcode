package easy;

/**
 * @author zhangjun
 * @version 2020/09/27  21:50
 */
public class Solution852 {
    //    public int peakIndexInMountainArray(int[] arr) {
//        int index = 1;
//        while(index < arr.length && arr[index] > arr[index - 1]){
//            index++;
//        }
//        return index - 1;
//    }

    public int peakIndexInMountainArray(int[] arr) {
        return binarySearch(arr, 0, arr.length - 1);
    }

    private int binarySearch(int[] arr, int lo, int hi) {
        if (hi - lo < 2) {
            return -1;
        }
        int mid = (hi - lo) / 2 + lo;
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        int l = binarySearch(arr, lo, mid);
        int r = binarySearch(arr, mid, hi);

        return (l == -1) ? r : l;
    }

}
