package easy;

/**
 * @author zhangjun
 * @version 2020/10/02  21:08
 */
public class Solution821 {
    public int[] shortestToChar(String S, char C) {
        int length = S.length();
        int [] map = new int[length];
        int [] result = new int[length];
        int size = 0;
        for(int  i = 0;i < length;++i){
            if(S.charAt(i) == C){
                map[size++] = i;
            }
        }
        int j;
        for(j = 0;j <= map[0];++j){
            result[j] = map[0] - j;
        }
        for(;j <= map[size - 1];++j){
            int index = 0;
            while(j > map[++index]);
            int lo = map[index - 1];
            int hi = map[index];
            int mid = (lo + hi) / 2;
            if(j <= mid){
                result[j] = j - lo;
            }else{
                result[j] = hi - j;
            }
        }
        for(;j < length;++j){
            result[j] = j - map[size - 1];
        }
        return result;
    }
}
