package medium;

/**
 * @author zhangjun
 * @version 2021/4/28
 */
public class Solution633 {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);
        while(left <= right){
            int t = left * left + right * right;
            if(t < c){
                ++left;
            }else if(t > c){
                --right;
            }else{
                return true;
            }
        }
        return false;
    }
}
