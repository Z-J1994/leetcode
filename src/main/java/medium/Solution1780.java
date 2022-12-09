package medium;

/**
 * @author zhangjun
 * @version 2022/12/9
 */
public class Solution1780 {
    public boolean checkPowersOfThree(int n) {
        //大于10^7的3的幂
        int m = 14348907;
        while(m > 0 && n > 0){
            if(n >= m){
                n -= m;
            }
            m /= 3;
        }
        return n == 0;
    }
}
