package hard;

import java.util.ArrayList;

/**
 * @author zhangjun
 * @date 2021/3/8
 */
public class Solution132 {

    public int minCut(String s) {
        int length = s.length();
        boolean [][] map = new boolean[length][length];

        for(int i = 0;i < length;i++){
            for(int j = 0;j < length;j++){
                map[i][j] = true;
            }
        }

        for(int i = length - 1;i >= 0;i--){
            for(int j = i + 1;j < length;j++){
                map[i][j] = (s.charAt(i) == s.charAt(j)) && map[i + 1][j - 1];
            }
        }
        int [] d = new int[length];
        for(int i = 0;i < length;i++){
            d[i] = i;
        }
        for(int i = 0;i < length;i++){
            if(map[0][i]){
                d[i] = 0;
            }else{
                for(int j = 0;j < i;j++){
                    if(map[j + 1][i]){
                        d[i] = Math.min(d[i],d[j] + 1);
                    }
                }
            }
        }

        return d[length - 1];
    }


    private boolean isPalindromeString(String s,int start,int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
