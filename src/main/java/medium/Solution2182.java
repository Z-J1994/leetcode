package medium;

/**
 * @author zhangjun
 * @since 2024/1/13 13:26
 */
public class Solution2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] alphabet = new int['z' + 1];
        for (int i = 0, l = s.length(); i < l; i++) {
            ++alphabet[s.charAt(i)];
        }
        char[] chars = new char[s.length()];
        int index = 0;
        for (int i = 'z', p = i - 1; i >= 'a'; i = p, p = p - 1) {
            int c = alphabet[i];
            char ch = (char) i;
            while (c > 0) {
                if (c > repeatLimit) {
                    for (int k = 0; k < repeatLimit; k++) {
                        chars[index++] = ch;
                    }
                    c -= repeatLimit;
                    while (p >= 'a' && alphabet[p] == 0) {
                        p--;
                    }
                    if (p < 'a') {
                        break;
                    }
                    if (alphabet[p] > 0) {
                        chars[index++] = (char) p;
                        --alphabet[p];
                    }
                } else {
                    for (int k = 0; k < c; k++) {
                        chars[index++] = ch;
                    }
                    c = 0;
                }
            }
        }
        return new String(chars, 0, index);
    }
}
