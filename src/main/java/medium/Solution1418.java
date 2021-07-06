package medium;

import java.util.*;

/**
 * @author zhangjun
 * @version 2021/7/6
 */
public class Solution1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<Integer, Map<String,Integer>> tMap = new TreeMap<>();
        TreeSet<String> foodList = new TreeSet<>();

        for(List<String> e : orders){
            int key = Integer.parseInt(e.get(1));
            Map<String, Integer> map = tMap.computeIfAbsent(key, k -> new HashMap<>());
            String foodItem = e.get(2);
            int t = map.getOrDefault(foodItem,0);
            map.put(foodItem,t + 1);
            foodList.add(foodItem);
        }

        List<List<String>>result = new ArrayList<>();
        List<String> l = new ArrayList<>();
        l.add("Table");
        l.addAll(foodList);
        result.add(l);
        int length = l.size();
        List<String> l1;
        for(Map.Entry<Integer,Map<String,Integer>> entry : tMap.entrySet()){
            l1 = new ArrayList<>();
            l1.add(String.valueOf(entry.getKey()));
            Map<String,Integer> v = entry.getValue();
            for(int i = 1;i < length;i++){
                l1.add(String.valueOf(v.getOrDefault(l.get(i),0)));
            }
            result.add(l1);
        }
        return result;
    }
}
