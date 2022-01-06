package easy;

/**
 * @author zhangjun
 * @version 2022/1/5
 */
public class Solution1576 {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '?') {
            chars[0] = 'a';
        }
        int t;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '?') {
                t = chars[i - 1] + 2;
                chars[i] = t > 'z' ? 'b' : (char) t;
            } else if (chars[i] == chars[i - 1]) {
                t = chars[i - 1] - 1;
                chars[i - 1] = t < 'a' ? 'z' : (char) t;
            }
        }
        return new String(chars);
    }
}
