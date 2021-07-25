package medium;

import java.util.*;

/**
 * @author zhangjun
 * @version 2021/7/25
 */
public class Solution1743 {

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for(int [] adjacentPair : adjacentPairs){
            int key = adjacentPair[0];
            int key1 = adjacentPair[1];

            ArrayList<Integer> list = graph.get(key);
            if(list == null){
                list = new ArrayList<>();
                graph.put(key,list);
            }
            list.add(key1);

            list = graph.get(key1);
            if(list == null){
                list = new ArrayList<>();
                graph.put(key1,list);
            }
            list.add(key);
        }
        int length = adjacentPairs.length;
        int [] result = new int[length + 1];
        int key = 0;
        for(Map.Entry<Integer,ArrayList<Integer>> entry:graph.entrySet()){
            if(entry.getValue().size() == 1){
                result[0] = entry.getKey();
                key = entry.getValue().get(0);
                break;
            }
        }

        for(int i = 1;i < length;i++){
            result[i] = key;
            ArrayList<Integer> list = graph.get(key);
            list.remove((Object)result[i - 1]);
            key = list.get(0);
        }
        result[length] = key;

        return result;
    }
}
