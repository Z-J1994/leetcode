package hard;

/**
 * @author zhangjun
 * @version 2021/9/27
 */
public class Solution639 {
    public int numDecodings(String s) {
        int n = s.length();

        long d1 = 1,d2 = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            long t = 0;

            if (c == '*') {
                t += d1 * 9;
                if (i + 1 < n) {
                    char p = s.charAt(i + 1);
                    long factor = 2;
                    if (p == '*') {
                        factor = 15;
                    } else if (p > '6') {
                        factor = 1;
                    }
                    t += d2 * factor;
                }
            } else if (c == '1') {
                t += d1;

                if (i + 1 < n) {
                    char p = s.charAt(i + 1);
                    long factor = 1;
                    if (p == '*') {
                        factor = 9;
                    }
                    t += d2 * factor;
                }
            } else if (c == '2') {
                t += d1;
                if (i + 1 < n) {
                    char p = s.charAt(i + 1);
                    long factor = 1;
                    if (p == '*') {
                        factor = 6;
                    } else if (p > '6') {
                        factor = 0;
                    }
                    t += d2 * factor;
                }
            } else if (c != '0') {
                t = d1;
            }
            d2 = d1;
            d1 = t % 1000000007 ;
        }
        return (int)d1;
    }
}
