package easy;

import java.util.HashMap;
import java.util.Map;

public class Solution599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i < list1.length;i++){
            map.put(list1[i],i);
        }
        String [] result = new String[Math.min(list2.length,list1.length)];
        int min = 0x7fffffff;
        Integer index;
        int t = 0;
        for(int i = 0;i < list2.length;i++){
            index = map.get(list2[i]);
            if( index != null){
                if(index + i < min){
                    t = 0;
                    result[t++] = list2[i];
                    min = index + i;
                }else if(index + i == min){
                    result[t++] = list2[i];
                }
            }
        }
        String[] r = new String[t];
        for(int i = 0;i < t;i++){
            r[i] = result[i];
        }
        return r;
    }
}
