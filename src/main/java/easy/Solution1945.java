package easy;

/**
 * @author zhangjun
 * @version 2022/12/15
 */
public class Solution1945 {
    public int getLucky(String s, int k) {
        int n = 0;
        for(int i = 0,l = s.length();i < l;i++){
            n += processor(s.charAt(i) - 96);
        }
        while(--k > 0){
            n = processor(n);
        }
        return n;
    }

    private int processor(int n){
        int t = 0;
        while(n > 0){
            t += n % 10;
            n /= 10;
        }
        return t;
    }
}
