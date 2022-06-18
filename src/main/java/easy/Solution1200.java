package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjun
 * @since 2022/6/17 13:01
 */
public class Solution1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = 0x7fffffff;
        int count = 0;
        for(int i = 1,t;i < arr.length;i++){
            if((t = arr[i] - arr[i - 1]) < min){
                min = t;
                count = 1;
            }else if(t == min){
                count++;
            }
        }

        List<List<Integer>> result = new ArrayList<>(count);
        for(int i = 1,t;i < arr.length;i++){
            if(arr[i] - arr[i - 1] == min){
                result.add(Arrays.asList(arr[i - 1],arr[i]));
            }
        }
        return result;
    }
}
