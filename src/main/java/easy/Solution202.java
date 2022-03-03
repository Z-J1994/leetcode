package easy;

/**
 * @author zhangjun
 * @version 2022/3/3
 */
public class Solution202 {
    public boolean isHappy(int n) {
        boolean [] map = new boolean[8101];
        int t = 0;
        while(n > 0){
            t += Math.pow(n % 10,2);
            n /= 10;
        }
        n = t;
        while(!map[n]){
            if(n == 1){
                return true;
            }
            map[n] = true;
            t = 0;
            while(n > 0){
                t += Math.pow(n % 10,2);
                n /= 10;
            }
            n = t;
        }
        return false;
    }
}
