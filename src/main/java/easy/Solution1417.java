package easy;

/**
 * @author zhangjun
 * @since 2022/8/11 13:16
 */
public class Solution1417 {
    public String reformat(String s) {
        char[] numbers = new char[s.length()];
        int i = 0;
        char[] chars = new char[s.length()];
        int c = 0;
        for (int j = 0; j < numbers.length; j++) {
            char ch = s.charAt(j);
            if (ch <= '9') {
                numbers[i++] = ch;
            } else {
                chars[c++] = ch;
            }
        }

        if (i > c) {
            if (i - c > 1) {
                return "";
            }
            return generator(numbers, i, chars, c);
        } else {
            if (c - i > 1) {
                return "";
            }
            return generator(chars, c, numbers, i);
        }
    }

    private String generator(char[] c1, int end1, char[] c2, int end2) {
        char[] result = new char[c1.length];
        for (int i = 0, j = 0; j < end2; j++) {
            result[i++] = c1[j];
            result[i++] = c2[j];
        }
        if (end1 > end2) {
            result[result.length - 1] = c1[end1 - 1];
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Solution1417 s = new Solution1417();
        System.out.println(s.reformat("a0b1c2"));
    }
}
