package easy;

/**
 * @author zhangjun
 * @version 2022/2/1
 */
public class Solution1763 {
    public String longestNiceSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            long map = get(chars[i]);
            int unMatched = 1;
            for (int j = i + 1; j < chars.length; j++) {
                long l = get(chars[j]);
                if (match(map, chars[j])) {
                    if ((map & l) == 0) {
                        --unMatched;
                    }
                } else if((map & l) == 0){
                    ++unMatched;
                }
                if (unMatched <= 0 && j - i > max) {
                    max = j - i;
                    left = i;
                }
                map = l | map;
            }
        }
        if(max == 0){
            return "";
        }
        return new String(chars, left, max + 1);
    }

    private long get(char c) {
        int l;
        if (c >= 'a') {
            l = c - 'a' + 26;
        } else {
            l = c - 'A';
        }
        return 1L << l;
    }

    private boolean match(long map, char c) {
        int l;
        if (c >= 'a') {
            l = c - 32 - 'A';
        } else {
            l = c + 32 - 'a' + 26;
        }
        return (map & (1L << l)) > 0;
    }

    public static void main(String[] args) {
        Solution1763 s = new Solution1763();
        System.out.println(s.longestNiceSubstring("YazaAay"));
        System.out.println(s.longestNiceSubstring("Bb"));
        System.out.println(s.longestNiceSubstring("c"));
        System.out.println(s.longestNiceSubstring("dDzeE"));
        System.out.println(s.longestNiceSubstring("ddD"));
        System.out.println(s.longestNiceSubstring("zUXxizubXNKAUGXTjmAXkpzNZMnRBgddDUAWPUa"));
    }
}
