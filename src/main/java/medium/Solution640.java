package medium;

/**
 * @author zhangjun
 * @since 2022/8/10 12:56
 */
public class Solution640 {
    public String solveEquation(String equation) {
        int[] left = processor(equation, 0);
        int[] right = processor(equation, left[2] + 1);
        left[0] -= right[0];
        left[1] -= right[1];

        if (left[0] == 0 && left[1] == 0) {
            return "Infinite solutions";
        }
        if (left[1] == 0) {
            return "No solution";
        }
        return "x=" + (-left[0] / left[1]);
    }

    private int[] processor(String equation, int startIndex) {
        int s = 0;
        int m = 0;
        int t = 0;
        int sign = 1;
        for (char c; startIndex < equation.length() && (c = equation.charAt(startIndex)) != '='; startIndex++) {
            if (c == 'x') {
                if (t == 0) {
                    if (startIndex == 0 || equation.charAt(startIndex - 1) != '0') {
                        m += sign;
                    }
                } else {
                    m += t * sign;
                    t = 0;
                }
                sign = 1;
            } else if (c == '+') {
                s += t * sign;
                t = 0;
                sign = 1;
            } else if (c == '-') {
                s += t * sign;
                t = 0;
                sign = -1;
            } else {
                t = t * 10 + c - '0';
            }
        }
        s += t * sign;
        return new int[]{s, m, startIndex};
    }

}
