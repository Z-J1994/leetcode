package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution816 {
    public List<String> ambiguousCoordinates(String s) {
        char[] chars = new char[s.length() - 2];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = s.charAt(i + 1);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0, l = chars.length - 1; i < l; i++) {
            List<String> l1 = processor(chars, 0, i);
            List<String> l2 = processor(chars, i + 1, l);
            for (String sl1 : l1) {
                for (String sl2 : l2) {
                    result.add('(' + sl1 + ", " + sl2 + ')');
                }
            }
        }
        return result;
    }

    private List<String> processor(char[] chars, int start, int end) {
        if (start == end) {
            return Collections.singletonList(new String(chars, start, 1));
        }
        if (chars[start] == '0') {
            if (chars[end] == '0') {
                return Collections.emptyList();
            }
            return Collections.singletonList("0." + new String(chars, start + 1, end - start));
        }
        if (chars[end] == '0') {
            return Collections.singletonList(new String(chars, start, end - start + 1));
        }
        List<String> l = new ArrayList<>();
        l.add(new String(chars, start, end - start + 1));
        for (int i = start + 1; i <= end; i++) {
            l.add(new String(chars, start, i - start) + "." + new String(chars, i, end - i + 1));
        }
        return l;
    }


    public static void main(String[] args) {
        Solution816 s = new Solution816();
//        System.out.println(s.ambiguousCoordinates("(123)"));
//        System.out.println(s.ambiguousCoordinates("(0123)"));
//        System.out.println(s.ambiguousCoordinates("(00011)"));
        System.out.println(s.ambiguousCoordinates("(0101)"));
    }
}
