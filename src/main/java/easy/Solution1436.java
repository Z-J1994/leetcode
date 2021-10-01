package easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangjun
 * @version 2020/09/22  19:27
 */
public class Solution1436 {
//    public String destCity(List<List<String>> paths) {
//        Map<String,Integer> map = new HashMap<>();
//        for(List<String> list : paths){
//            String source = list.get(0);
//            String distance = list.get(1);
//            map.put(source,1);
//            if(!map.containsKey(distance)){
//                map.put(distance,0);
//            }
//        }
//        String key = "";
//        for(Map.Entry<String,Integer> entry: map.entrySet()){
//            if(entry.getValue() == 0){
//               key =  entry.getKey();
//            }
//        }
//        return key;
//    }

    //2021/10/1二刷
    public String destCity(List<List<String>> paths) {
        Map<String,String> map = new HashMap<>();
        for(List<String> list : paths){
            map.put(list.get(0),list.get(1));
        }

        String next = paths.get(0).get(0);
        String result = null;
        while(next != null){
            result = next;
            next = map.get(next);
        }
        return result;
    }

}
