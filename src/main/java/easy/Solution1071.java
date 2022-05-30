package easy;

/**
 * @author zhangjun
 * @since 2022/5/30 12:42
 */
public class Solution1071 {
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int gcd = gcd(l1, l2);
        if (check(chars1, chars2, gcd) && check(chars2, chars1, gcd)) {
            return new String(chars1, 0, gcd);
        }
        return "";
    }

    private boolean check(char[] chars1, char[] chars2, int step) {
        for (int i = 0; i < chars1.length; i += step) {
            for (int j = 0; j < step; j++) {
                if (chars1[i + j] != chars2[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int gcd(int p, int q) {
        int r;
        while (q != 0) {
            r = p % q;
            p = q;
            q = r;
        }
        return p;
    }

    public static void main(String[] args) {
        Solution1071 s = new Solution1071();
        System.out.println(s.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(s.gcdOfStrings("LEET", "CODE"));
    }
}
