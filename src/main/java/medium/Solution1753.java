package medium;

/**
 * @author zhangjun
 * @version 2022/12/21
 */
public class Solution1753 {
    public int maximumScore(int a, int b, int c) {
        if(a > b){
            int t = a;
            a = b;
            b = t;
        }
        if(b > c){
            int t = b;
            b = c;
            c = t;
        }
        if(a > b){
            int t = a;
            a = b;
            b = t;
        }
        int s = a + b;
        return s > c ? c + (s - c) / 2 : s;
    }
}
