package hard;

import utils.Parser;

import java.util.Arrays;

/**
 * @author zhangjun
 * @since 2024/1/5 13:14
 */
public class Solution1944 {
    public int[] canSeePersonsCount(int[] heights) {
        int length = heights.length;
        int [] answer = new int[length];
        int [] stack = new int[length + 1];
        stack[0] = -1 >>> 1;
        stack[1] = heights[length - 1];
        for(int i = length - 2,si = 1,v,t;i >= 0;i--){
            v = heights[i];
            t = 0;
            while(v > stack[si]){
                t++;
                si--;
            }
            if(si > 0){
                t++;
            }
            stack[++si] = v;
            answer[i] = t;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution1944 s = new Solution1944();
        System.out.println(Arrays.toString(s.canSeePersonsCount(Parser.StringToIntArray("[10,6,8,5,11,9]"))));
    }
}
