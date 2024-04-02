package easy;

/**
 * @author zhangjun
 * @version 2020/12/27/ 8:19
 */
public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        char[] maps = new char[128];
        char[] mapt = new char[128];
        for (int i = 0, length = s.length(); i < length; i++) {
            char c = s.charAt(i);
            char c1 = t.charAt(i);
            if (maps[c] == 0) {
                if (mapt[c1] != 0) {
                    return false;
                }
                maps[c] = c1;
                mapt[c1] = c;
            } else if (maps[c] != c1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution205 s = new Solution205();
        String s1 = "egg";
        String t1 = "add";

        String s2 = "foo";
        String t2 = "bar";

        String s3 = "paper";
        String t3 = "title";

        String s4 = "ab";
        String t4 = "aa";

        String s5 = "13";
        String t5 = "42";

        System.out.println(s.isIsomorphic(s1, t1));//true
        System.out.println(s.isIsomorphic(s2, t2));//false
        System.out.println(s.isIsomorphic(s3, t3));//true
        System.out.println(s.isIsomorphic(s4, t4));//false
        System.out.println(s.isIsomorphic(s5, t5));//true

    }
}
