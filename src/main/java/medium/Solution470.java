package medium;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2021/9/5
 */
public class Solution470 {
    static int [] map = new int[71];
    public static void main(String[] args) {
        dfs(0,1);
        System.out.println(Arrays.toString(map));
        int sum = 0;
        for(int i = 0;i < 71;i++){
            sum += map[i];
        }
        System.out.println(sum);
    }
    private static void dfs(int sum,int length){
        if(length > 10){
            map[sum]++;
            return;
        }
        for(int i = 1;i <= 7;i++){
            dfs(sum + i,length + 1);
        }
    }
}
