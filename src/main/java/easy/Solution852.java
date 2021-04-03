package easy;

/**
 * @author zhangjun
 * @version 2020/09/27  21:50
 */
public class Solution852 {
    public int peakIndexInMountainArray(int[] arr) {
        int index = 1;
        while(index < arr.length && arr[index] > arr[index - 1]){
            index++;
        }
        return index - 1;
    }
}
