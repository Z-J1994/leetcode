package medium;

/**
 * @author zhangjun
 * @version 2021/9/26
 */
public class Solution371 {
    public int getSum(int a, int b) {
        while(b != 0){
            int carry = a & b;
            a = (a | b) & (~carry);
            b = carry << 1;
        }
        return a;
    }
}
