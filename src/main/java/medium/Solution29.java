package medium;

/**
 * @author zhangjun
 * @version 2021/10/12
 */
public class Solution29 {
    public int divide(int dividend, int divisor) {
        boolean negative = (dividend >>> 31) != (divisor >>> 31);

        //转换成同号(负数比正数范围大1,转换成负数)
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        if (dividend == 0 || divisor < dividend) {
            return 0;
        }

        if (dividend == divisor) {
            return negative ? -1 : 1;
        }
        if (divisor == -1) {
            //整数除法溢出的唯一情况是 dividend == -2147483648 && (未改变符号之前)divisor == -1
            if (dividend == 0x80000000 && !negative) {
                return 0x7fffffff;
            }
            return negative ? dividend : -dividend;
        }

        int result = 0;

        while (dividend <= divisor) {

            // 因为 (a + b) / c = a / c + b / c;
            // divisor * Math.pow(2,x) <= dividend && divisor * Math.pow(2,x + 1) > dividend 求出 x
            // 设 dividend = divisor * Math.pow(2,x) + t;然后问题转换成求 x + t / divisor
            // Math.pow(2,x) 为什么取2 ? ,因为整数每次左移相当于 *2

            int t = divisor;
            int quotient = 1;
            //当t < 0x60000000时,t << 1 会溢出,所以记录每次位移之前的数字
            int previous = 0;
            while (t > dividend && t < 0) {
                previous = t;
                t = t << 1;
                quotient = quotient << 1;

            }
            if (t != dividend) {
                quotient = quotient >> 1;
                dividend -= previous;
            } else {
                dividend -= t;
            }

            result += quotient;
        }
        return negative ? -result : result;
    }
}
