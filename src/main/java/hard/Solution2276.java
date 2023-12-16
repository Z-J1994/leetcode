package hard;

import utils.Invoker;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Solution2276 {

    class CountIntervals {

        private final TreeMap<Integer, int[]> map;

        private int count;

        public CountIntervals() {
            map = new TreeMap<>();
            count = 0;
        }

        public void add(int left, int right) {
            Map.Entry<Integer, int[]> floorEntry = map.floorEntry(left);
            int[] value;
            if (floorEntry != null) {
                value = floorEntry.getValue();
                if (value[1] == left) {
                    count -= value[1] - value[0] + 1;
                    left = value[0];
                    map.remove(value[1]);
                }
            }
            Map.Entry<Integer, int[]> ceilingEntry;
            while ((ceilingEntry = map.ceilingEntry(left)) != null) {
                value = ceilingEntry.getValue();
                if (value[0] > right) {
                    break;
                }
                count -= value[1] - value[0] + 1;
                map.remove(value[1]);
                if (value[1] > right) {
                    right = value[1];
                }
                if (value[0] < left) {
                    left = value[0];
                }
            }
            count += right - left + 1;
            map.put(right, new int[]{left, right});
        }

        public int count() {
            return count;
        }
    }


    public static void main(String[] args) {
        Object[] parameters;
//        parameters = new Object[]{null, new int[]{2, 3}, new int[]{7, 10}, null, new int[]{5, 8}, null};
//        System.out.println(Arrays.toString(Invoker.invoke(CountIntervals.class,parameters,new Integer[parameters.length],new String[]{"CountIntervals","add","add","count","add","count"})));
        parameters = new Object[]{null, null, new int[]{8, 43}, new int[]{13, 16}, new int[]{26, 33}, new int[]{28, 36}, new int[]{29, 37}, null, new int[]{34, 46}, new int[]{10, 23}};
        System.out.println(Arrays.toString(Invoker.invoke(CountIntervals.class, parameters, new Integer[parameters.length], new String[]{"CountIntervals", "count", "add", "add", "add", "add", "add", "count", "add", "add"})));
    }
}
