package easy;

/**
 * @author zhangjun
 * @version 2020/09/19  14:32
 */
public class Solution1281 {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        int b;
        while(n > 0){
            b = n % 10;
            n /= 10;
            sum += b;
            product *= b;
        }
        return product - sum;
    }
}
