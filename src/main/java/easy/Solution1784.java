package easy;

public class Solution1784 {
    public boolean checkOnesSegment(String s) {
        int length = s.length();
        int i = 0;
        while (++i < length && s.charAt(i) == '1') ;
        if (i >= length) {
            return true;
        }
        while (++i < length && s.charAt(i) == '0') ;
        return i >= length;
    }
}
