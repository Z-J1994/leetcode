package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @date 2021/3/7
 */
public class Solution131 {
    List<List<String>> result = new ArrayList<>();
    ArrayList<String> r = new ArrayList<>();
    boolean [][] map;

    public List<List<String>> partition(String s) {
        int length = s.length();
        map = new boolean[length][length];

        for(int i = 0;i < length;i++){

            for(int j = 0;j < length;j++){
                if(isPalindromeString(s,i,j)){
                    map[i][j] = true;
                }
            }
        }
        spilt(s,0,length);
        return result;
    }

    private void spilt(String s,int start,int end){
        if(start == end){
            result.add(new ArrayList<>(r));
            return;
        }
       for(int i = start;i < end;i++){
           if(map[start][i]){
               r.add(s.substring(start,i + 1));
               spilt(s,i + 1,end);
               r.remove(r.size() - 1);
           }
       }
    }

    private boolean isPalindromeString(String s,int start,int end){
        while(start < end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution131 s = new Solution131();
        String s1 = "abb";
        s.partition(s1);
    }
}
