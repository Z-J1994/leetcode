package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int p = 1;
        for(int i : target){
            while(i > p){
                list.add("Push");
                list.add("Pop");
                p++;
            }
            list.add("Push");
            p++;
        }
        return list;
    }
}
