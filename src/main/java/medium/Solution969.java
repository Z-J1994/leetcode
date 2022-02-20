package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2022/2/19
 */
public class Solution969 {
    public List<Integer> pancakeSort(int[] arr) {
        int index = arr.length - 1;
        List<Integer> result = new ArrayList<>();
        while(index > 0){
            int l = getMax(arr,index);
            if(l != index){
                if(l != 0){
                    reverse(arr,l);
                    result.add(l + 1);
                }
                reverse(arr,index);
                result.add(index + 1);
            }
            --index;
        }
        return result;
    }

    private void reverse(int [] data,int limit){
        for(int i = 0,t;i < limit;i++,limit--){
            t = data[i];
            data[i] = data[limit];
            data[limit] = t;
        }
    }

    private int getMax(int [] data,int limit){
        int index = limit;
        while(--limit >= 0){
            if(data[limit] > data[index]){
                index = limit;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        Solution969 s = new Solution969();
        System.out.println(s.pancakeSort(new int[]{3, 2, 4, 1}));
    }
}
