package medium;

import java.util.Arrays;
import java.util.Comparator;

public class Solution646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int count= 0;
        int p = 0x80000000;
        for(int [] pair:pairs){
            if(pair[0] > p){
                count++;
                p = pair[1];
            }
        }
        return count;
    }
}
