package medium;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2021/7/11
 */
public class Solution274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int k = 0;
        for(int i = citations.length - 1;i >= 0;i--,k++){
            if(citations[i] <= k){
                break;
            }
        }

        return k;
    }
}
