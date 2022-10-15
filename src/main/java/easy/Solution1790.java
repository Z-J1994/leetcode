package easy;

/**
 * @author zhangjun
 * @version 2022/10/11
 */
public class Solution1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] difference = new int[2];
        int index = -1;
        for (int i = 0, l = s1.length(); i < l; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (++index < 2) {
                    difference[index] = i;
                } else {
                    return false;
                }
            }
        }
        return index == -1 || (index == 1 && s1.charAt(difference[0]) == s2.charAt(difference[1]) && s1.charAt(difference[1]) == s2.charAt(difference[0]));
    }
}
