package easy;

/**
 * @author zhangjun
 * @version 2020/09/22  22:13
 */
public class Solution1299 {
    public int[] replaceElements(int[] arr) {
        int length = arr.length - 1;
        int max = -1;
        int t = -1;
        for(int i = length;i >= 0;i--){
            if(arr[i] > max){
                t = arr[i];
            }
            arr[i] = max;
            max = t;
        }
        return arr;
    }
}
