package easy;

/**
 * @author zhangjun
 * @version 2021/4/10
 */
public class Solution263 {
    public boolean isUgly(int n) {
        int factor = 2;
        while(n > 1 && factor <= 5){
            if(n % factor == 0){
                n /= factor;
            }else{
                ++factor;
            }
        }
        return n ==1;
    }
}
