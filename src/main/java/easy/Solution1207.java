package easy;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2020/09/28  19:46
 */
public class Solution1207 {

    public boolean uniqueOccurrences(int[] arr) {
       int [] result = new int[arr.length];
       Arrays.sort(arr);
       int index = 0;
       result[index] = 1;
       for(int i = 1;i < arr.length;i++){
           if(arr[i] != arr[i - 1]){
               index++;
           }
           result[index]++;
       }
       Arrays.sort(result,0,index);
       for(int i = 1;i <= index;i++){
           if(result[i] == result[i - 1]){
               return false;
           }
       }
       return true;
    }
}
