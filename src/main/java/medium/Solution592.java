package medium;

/**
 * @author zhangjun
 * @since 2022/7/27 13:04
 */
public class Solution592 {

    public String fractionAddition(String expression) {
        int denominator1 = 1;
        int numerator1 = 0;

        for (int i = 0, l = expression.length(); i < l; ) {
            int[] result = getNumber(expression, i);
            int numerator2 = result[0];
            i = result[1] + 1;

            result = getNumber(expression, i);
            int denominator2 = result[0];
            i = result[1];

            int d = denominator1 * denominator2;
            int n = numerator1 * denominator2 + numerator2 * denominator1;

            denominator1 = d;
            numerator1 = n;
            int g = gcd(d, n);
            if (g > 1) {
                denominator1 /= g;
                numerator1 /= g;
            }
        }
        if(denominator1 < 0){
            denominator1 = -denominator1;
            numerator1 = -numerator1;
        }
        return numerator1 + "/" + denominator1;
    }

    private int[] getNumber(String expression, int start) {
        int sign = 1;
        int result = 0;
        int l = expression.length();
        if (expression.charAt(start) == '-') {
            sign = -1;
            start++;
        } else if (expression.charAt(start) == '+') {
            start++;
        }
        for (char c; start < l && ((c = expression.charAt(start)) != '-' && c != '+' && c != '/'); start++) {
            result = result * 10 + (c - '0');
        }
        return new int[]{result * sign, start};
    }

    private int gcd(int p, int q) {
        while (q != 0) {
            int remainder = p % q;
            p = q;
            q = remainder;
        }
        return Math.abs(p);
    }

    public static void main(String[] args) {
        Solution592 s = new Solution592();
//        System.out.println(s.fractionAddition("-1/2+1/2"));
        System.out.println(s.fractionAddition("1/3-1/2"));
    }
}
