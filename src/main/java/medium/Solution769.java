package medium;

/**
 * @author zhangjun
 * @version 2022/10/13
 */
public class Solution769 {
    public int maxChunksToSorted(int[] arr) {
        int result = 0;
        for(int i = 0,max = 0;i < arr.length;i++){
            max = Math.max(max,arr[i]);
            if(max == i){
                result++;
            }
        }
        return result;
    }
}
