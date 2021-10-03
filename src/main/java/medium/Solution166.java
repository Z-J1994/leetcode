package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjun
 * @version 2021/10/3
 */
public class Solution166 {
    private int index;
    private char[] chars = new char[10];

    public String fractionToDecimal(int n, int d) {
        index = 0;
        long numerator = Math.abs((long) n);
        long denominator = Math.abs((long) d);

        boolean negative = false;
        if ((n & 0x80000000) != (d & 0x80000000)) {
            add('-');
            negative = true;
        }

        long t = numerator / denominator;
        add(t);
        numerator = numerator % denominator;
        if (numerator != 0) {
            add('.');
        } else if (negative && t == 0) {
            return new String(chars, 1, index - 1);
        }

        Map<Long, Integer> map = new HashMap<>();
        while (numerator != 0) {
            Integer i = map.get(numerator);
            if (i != null) {
                add(')');
                //如果空间不足则触发扩容
                add('(');
                for (int k = index - 1; k > i; k--) {
                    chars[k] = chars[k - 1];
                }
                chars[i] = '(';
                break;
            }

            map.put(numerator, index);
            numerator *= 10;

            add(numerator / denominator);
            numerator = numerator % denominator;
        }
        return new String(chars, 0, index);
    }

    private void add(char c) {
        if (index == chars.length) {
            grow(index << 1);
        }
        chars[index++] = c;
    }

    private void add(long n) {

        if (n == 0) {
            add('0');
            return;
        }

        long t = 1;
        while (t <= n) {
            t *= 10;
        }

        t /= 10;

        while (t > 0) {
            add((char) ((n / t) + 48));
            n %= t;
            t /= 10;
        }
    }

    private void grow(int capacity) {
        char[] newChar = new char[capacity];
        System.arraycopy(chars, 0, newChar, 0, chars.length);
        chars = newChar;
    }

    public static void main(String[] args) {
        Solution166 s = new Solution166();
        System.out.println(s.fractionToDecimal(-2147483647, 1));
        System.out.println(s.fractionToDecimal(2147483647, 1));
        System.out.println(s.fractionToDecimal(-1, -2147483648));
        System.out.println(s.fractionToDecimal(1, 1));
        System.out.println(s.fractionToDecimal(500, 10));
        System.out.println(s.fractionToDecimal(1, 17));
        System.out.println(s.fractionToDecimal(1, 2));
        System.out.println(s.fractionToDecimal(2, 1));
        System.out.println(s.fractionToDecimal(2, 3));
        System.out.println(s.fractionToDecimal(4, 333));
        System.out.println(s.fractionToDecimal(1, 5));
    }
}
