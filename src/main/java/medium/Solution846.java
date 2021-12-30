package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjun
 * @version 2021/12/30
 */
public class Solution846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        if(groupSize == 1){
            return true;
        }
        Map<Integer,IntHolder> map = new HashMap<>();
        for (int t : hand) {
            IntHolder h = map.get(t);
            if (h == null) {
                h = new IntHolder();
                map.put(t, h);
            }
            h.value++;
        }
        Arrays.sort(hand);
        for(int i : hand){
            IntHolder p = map.get(i);
            if(p.value == 0){
                continue;
            }
            for(int j = 1;j < groupSize;j++){
                IntHolder h = map.get(i + j);
                if(h == null || h.value < p.value){
                    return false;
                }
                h.value -= p.value;
            }
            p.value = 0;
        }
        return true;
    }

    private static class IntHolder{
        int value;
    }

    public static void main(String[] args) {
        Solution846 s = new Solution846();
        System.out.println(s.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
    }
}
