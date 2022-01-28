package easy;

/**
 * @author zhangjun
 * @version 2022/1/25
 */
public class Solution1688 {
    public int numberOfMatches(int n) {
        int sum = 0;
        while(n != 1){
            sum += (n & 1) + (n = n / 2);
        }
        return sum;
    }
}
