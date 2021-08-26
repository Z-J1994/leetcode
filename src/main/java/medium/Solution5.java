package medium;

/**
 * @author zhangjun
 * @version 2021/8/26
 */
public class Solution5 {
    int offset = 0;
    int count = 1;
    int length;

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        length = s.length();
        for (int i = 0; i < length; i++) {
            counter(i, i + 1, chars);
            counter(i - 1, i + 1, chars);
        }
        return new String(chars, offset, count);
    }

    private void counter(int left, int right, char[] chars) {

        while (left >= 0 && right < length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        right--;
        left++;
        int l = right - left + 1;
        if (l > count) {
            offset = left;
            count = l;
        }
    }
}
