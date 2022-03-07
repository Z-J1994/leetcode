package easy;

/**
 * @author zhangjun
 * @version 2022/3/7
 */
public class Solution504 {
    public String convertToBase7(int num) {
        int result = 0;
        int factor = 1;
        int sign = 1;
        if(num < 0){
            num = -num;
            sign = -1;
        }
        while(num > 0){
            result += (num % 7) * factor;
            num /= 7;
            factor *= 10;
        }
        return String.valueOf(result * sign);
    }
}
