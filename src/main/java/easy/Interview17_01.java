package easy;

/**
 * @author zhangjun
 * @version 2020/10/07  22:27
 */
public class Interview17_01 {
    public int add(int a, int b) {
        while(b != 0){
            int carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }
        return a;
    }
}
