package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangjun
 * @version 2021/7/10
 */
public class Solution981 {

    static class TimeMap {
        private static class Pair{
            String value;
            int timestamp;
            private Pair(String value,int timestamp){
                this.value = value;
                this.timestamp = timestamp;
            }
        }

        private Map<String,List<Pair>> map;

        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            List<Pair> list = map.get(key);
            if(list == null){
                list = new ArrayList<>();
                map.put(key,list);
            }
            list.add(new Pair(value,timestamp));
        }

        public String get(String key, int timestamp) {
            List<Pair> list = map.get(key);
            if(list != null){
                for(int i = list.size() - 1;i >= 0;i--){
                    Pair p = list.get(i);
                    if(p.timestamp <= timestamp){
                        return p.value;
                    }
                }
            }
            return "";
        }
    }
}
