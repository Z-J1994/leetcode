package easy;

/**
 * @author zhangjun
 * @version 2021/9/23
 */
public class Solution326 {
    public boolean isPowerOfThree(int n) {
        int t = 1;
        while(t > 0 && t < n){
            t *= 3;
        }
        return t == n;
    }
}
