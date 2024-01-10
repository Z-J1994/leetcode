package easy;

/**
 * @author zhangjun
 * @since 2024/1/10 13:15
 */
public class Solution2696 {
    public int minLength(String s) {
        char[] chars = new char[s.length()];
        int index = -1;
        for (int j = 0; j < chars.length; j++) {
            char c = s.charAt(j);
            if (index < 0) {
                chars[++index] = c;
            } else if (c == 'B') {
                if (chars[index] == 'A') {
                    index--;
                }else{
                    chars[++index] = c;
                }
            } else if (c == 'D'){
                if (chars[index] == 'C') {
                    index--;
                }else{
                    chars[++index] = c;
                }
            }else {
                chars[++index] = c;
            }
        }
        return index + 1;
    }


    public static void main(String[] args) {
        Solution2696 s = new Solution2696();
        System.out.println(s.minLength("ABFCACDB") == 2);
        System.out.println(s.minLength("ACBBD") == 5);
    }
}
