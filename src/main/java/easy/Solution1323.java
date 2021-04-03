package easy;

/**
 * @author zhangjun
 * @version 2020/09/23  15:22
 */
public class Solution1323 {
    public int maximum69Number (int num) {
        boolean marked = true;
        int sum = 0;
        int q = 1;
        int temp = num;

        while(temp > 0){
            temp /= 10;
            q *= 10;
        }
        q /= 10;
        while(num > 0){
            int b = num / q % 10;
            num %= q;
            if(b == 6 && marked){
                b = 9;
                marked = false;
            }
            sum += b * q;
            q /= 10;
        }
        return sum;
    }
}
