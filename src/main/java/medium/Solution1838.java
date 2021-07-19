package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjun
 * @version 2021/7/19
 */
public class Solution1838 {
    public int maxFrequency(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int key : nums){
            int count = map.getOrDefault(key,0);
            map.put(key,count + 1);
        }

        int length = map.size();
        int [] data = new int [length];
        int index = 0;
        for(int key : map.keySet()){
            data[index++] = key;
        }
        Arrays.sort(data);
        int max = 0;
        index = 0;
        for(;index < length;index++){
            int key = data[index];
            int count = map.get(key);
            for(int i = k,j = index - 1;i > 0 && j >= 0;j--){
                int k1 = data[j];
                int v = map.get(k1);
                int diff = (key - k1);
                if(i < v * diff){
                    count += i / diff;
                    break;
                }
                count += v;
                i -= v * diff;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}
