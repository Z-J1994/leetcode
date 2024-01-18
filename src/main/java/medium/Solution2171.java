package medium;

import utils.Parser;

import java.util.Arrays;

public class Solution2171 {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum = 0;
        for(int bean : beans){
            sum += bean;
        }
        long min = -1L >>> 1;
        for (int i = 0, l = beans.length ; i < l; i++) {
            long k =  sum - ((long)l - i) * beans[i];
            if(k < min){
                min = k;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        Solution2171 s = new Solution2171();
        System.out.println(s.minimumRemoval(Parser.StringToIntArray("[4,1,6,5]")) == 4);
        System.out.println(s.minimumRemoval(Parser.StringToIntArray("[2,10,3,2]")) == 7);
        System.out.println(s.minimumRemoval(Parser.StringToIntArray("[63,43,12,94]")) == 83);
    }
}
