package medium;

import java.util.Arrays;

public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        if(length < 2){
            return 0;
        }
        Arrays.sort(intervals,(i,j)-> i[0] != j[0] ? i[0] - j[0] : i[1] - j[1]);

        int num = 0;
        int []s = intervals[0];
        int s1 = s[1];
        for(int i = 1;i < length;i++){
            int []t= intervals[i];
            if(s1 >= t[1]){
                s = t;
                s1 = s[1];
                num++;
            }else if(s1 > t[0]){
                num++;
            }else{
                s = t;
                s1 = s[1];
            }

        }
        return num;
    }


    public static void main(String[] args) {

        Solution435 s = new Solution435();
        int [][] i1 = { {1,2}, {2,3}, {3,4}, {1,3} };
        int [][] i2 = { {1,2}, {1,2}, {1,2} };
        int [][] i3 = { {1,2}, {2,3}};
        int [][] i4 = {};
        int [][] i5 = {{1,2}};
        System.out.println(s.eraseOverlapIntervals(i1));//1;
        System.out.println(s.eraseOverlapIntervals(i2));//2;
        System.out.println(s.eraseOverlapIntervals(i3));//0;
        System.out.println(s.eraseOverlapIntervals(i4));//0;
        System.out.println(s.eraseOverlapIntervals(i5));//0;
    }
}
