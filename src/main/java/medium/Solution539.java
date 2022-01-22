package medium;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhangjun
 * @version 2022/1/18
 */
public class Solution539 {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() > 1440){
            return 0;
        }
        timePoints.sort(String::compareTo);
        Iterator<String> iterator = timePoints.iterator();
        int p = convert(iterator.next());
        int first = p;
        int c = 0;
        int t;
        int min = 0x7FFFFFFF;
        while (iterator.hasNext()) {
            c = convert(iterator.next());
            t = c - p;
            if(t < min){
                min = t;
            }
            p = c;
        }
        t = c - first;
        if((t << 1) > 1440){
            t = 1440 - t;
        }
        return Math.min(t, min);
    }

    private int convert(String time) {
        return charAt(time,4) + charAt(time,3) * 10 + charAt(time,1) * 60 + charAt(time,0) * 600;
    }

    private int charAt(String s,int index){
        return s.charAt(index) - '0';
    }

    public static void main(String[] args) {
        Solution539 s = new Solution539();
        System.out.println(s.findMinDifference(Arrays.asList("23:59", "00:00")) == 1);
        System.out.println(s.findMinDifference(Arrays.asList("00:00","23:59","00:00")) == 0);
    }
}
