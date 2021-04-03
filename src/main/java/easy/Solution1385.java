package easy;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2020/09/27  22:07
 */
public class Solution1385 {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int num = 0;
        for(int v1: arr1){
            boolean marked = true;
            for(int v: arr2){
                if(Math.abs( v1 - v) <= d){
                    marked = false;
                }
            }
            if(marked){
                num++;
            }
        }
        return num;
    }
}
