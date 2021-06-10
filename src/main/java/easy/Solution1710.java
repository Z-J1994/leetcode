package main.java.easy;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2021/6/10
 */
public class Solution1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(int [] i, int [] j) -> j[1] - i[1]);
        int result = 0;
        for(int [] i : boxTypes){
            if(truckSize == 0){
                break;
            }
            int t = i[0];
            if(truckSize < t){
                t = truckSize;
            }
            truckSize -= t;
            result += t * i[1];
        }
        return result;
    }
}
