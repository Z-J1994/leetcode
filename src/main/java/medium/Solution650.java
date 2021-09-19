package medium;

/**
 * @author zhangjun
 * @version 2021/9/19
 */
public class Solution650 {
    public int minSteps(int n) {
        int result = 0;
        while(n > 1){
            int t = factor(n);
            result += n / t;
            n = t;
        }
        return result;
    }

    private int factor(int n){
        for(int i = n / 2,l = (int)Math.sqrt(n);i >= l;i--){
            if(n % i == 0){
                return i;
            }
        }
        return 1;
    }
}
