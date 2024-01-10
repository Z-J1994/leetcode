package easy;

/**
 * @author zhangjun
 * @since 2024/1/10 13:15
 */
public class Solution2696 {
    public int minLength(String s) {
        char[] chars = s.toCharArray();
        int[] stack = new int[chars.length];

        for (int j = 1,index = 0; j < chars.length; j++) {
            if (chars[j] == 'B') {
                if (index >= 0 && chars[stack[index]] == 'A') {
                    chars[stack[index]] = 0;
                    chars[j] = 0;
                    index--;
                }
            } else if (chars[j] == 'D') {
                if (index >= 0 && chars[stack[index]] == 'C') {
                    chars[stack[index]] = 0;
                    chars[j] = 0;
                    index--;
                }
            }

            if (chars[j] != 0) {
                stack[++index] = j;
            }
        }

        int c = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                c++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Solution2696 s = new Solution2696();
        System.out.println(s.minLength("ABFCACDB"));
    }
}
