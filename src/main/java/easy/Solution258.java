package easy;

/**
 * @author zhangjun
 * @version 2020/10/02  20:00
 */
public class Solution258 {
    public int addDigits(int num) {
        while(num >= 10){
            int sum = 0;
            while(num > 0){
                int t = num % 10;
                num /= 10;
                sum += t;
            }
            num = sum;
        }
        return num;
    }
}
