package easy;

/**
 * @author zhangjun
 * @version 2022/3/10
 */
public class Solution374 {
    public int guessNumber(int n) {
        int t;
        int lo = 1,hi = n;
        while((t = guess(n = ((lo + hi) >>> 1))) != 0){
            if(t == 1){
                lo = n + 1;
            }else{
                hi = n - 1;
            }
        }
        return n;
    }

    int guess(int num){
        return 0;
    }
}
