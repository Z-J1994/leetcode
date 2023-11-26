package medium;

/**
 * @author zhangjun
 * @since 2023/11/23 13:27
 */
public class Solution1410 {
    private static final char[][] SYMBOLS = {{' ', 'q', 'u', 'o', 't', '"'}, {' ', 'a', 'p', 'o', 's', '\''}, {' ', 'a', 'm', 'p', '&'},
            {' ', 'g', 't', '>'}, {' ', 'l', 't', '<'}, {' ', 'f', 'r', 'a', 's', 'l', '/'}};

    private static final int[] PAIR = {0, 0};

    public String entityParser(String text) {
        char[] chars = text.toCharArray();
        int i = 0;
        for (int j = 0; j < chars.length; j++,i++) {
            chars[i] = chars[j];
            if (chars[j] == '&') {
                if (j + 5 < chars.length && chars[j + 1] == 'q' && chars[j + 5] == ';') {
                    int[] ints = match(chars, i, j, SYMBOLS[0]);
                    i = ints[0];
                    j = ints[1];
                } else if (j + 5 < chars.length && chars[j + 1] == 'a' && chars[j + 5] == ';') {
                    int[] ints = match(chars, i, j, SYMBOLS[1]);
                    i = ints[0];
                    j = ints[1];
                } else if (j + 4 < chars.length && chars[j + 1] == 'a' && chars[j + 4] == ';') {
                    int[] ints = match(chars, i, j, SYMBOLS[2]);
                    i = ints[0];
                    j = ints[1];
                } else if (j + 3 < chars.length && chars[j + 1] == 'g' && chars[j + 3] == ';') {
                    int[] ints = match(chars, i, j, SYMBOLS[3]);
                    i = ints[0];
                    j = ints[1];
                } else if (j + 3 < chars.length && chars[j + 1] == 'l' && chars[j + 3] == ';') {
                    int[] ints = match(chars, i, j, SYMBOLS[4]);
                    i = ints[0];
                    j = ints[1];
                } else if (j + 6 < chars.length && chars[j + 1] == 'f' && chars[j + 6] == ';') {
                    int[] ints = match(chars, i, j, SYMBOLS[5]);
                    i = ints[0];
                    j = ints[1];
                }
            }
        }
        return new String(chars, 0, i);
    }

    private int[] match(char[] chars, int i, int j, char[] symbol) {
        if (symbol != null) {
            int k;
            int l = symbol.length - 1;
            for (k = 1; k < l; k++) {
                if (symbol[k] != chars[j + k]) {
                    break;
                }
                chars[i + k] = chars[j + k];
            }
            if (k == l) {
                chars[i] = symbol[l];
                j += k;
            } else {
                i += k - 1;
                j += k - 1;
            }
        }
        PAIR[0] = i;
        PAIR[1] = j;
        return PAIR;
    }

    public static void main(String[] args) {
        Solution1410 s = new Solution1410();
        System.out.println(s.entityParser("&a&gt;").equals("&a>"));
        System.out.println(s.entityParser("&amp; is an HTML entity but &ambassador; is not.").equals("& is an HTML entity but &ambassador; is not."));
        System.out.println(s.entityParser("and I quote: &quot;...&quot;").equals("and I quote: \"...\""));
        System.out.println(s.entityParser("&amp1; is an HTML entity but &ambassador; is not.").equals("&amp1; is an HTML entity but &ambassador; is not."));
    }
}
