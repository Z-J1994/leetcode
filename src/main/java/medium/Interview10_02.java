package medium;

import java.util.*;

/**
 * @author zhangjun
 * @version 2021/7/18
 */
public class Interview10_02 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<MyString, List<String>> map = new HashMap<>();
        for (String s : strs) {
            MyString key = new MyString(s);
            List<String> t = map.get(key);
            if (t == null) {
                t = new ArrayList<>();
                map.put(key, t);
            }
            t.add(s);
        }
        return new ArrayList<>(map.values());
    }

    private static class MyString {
        private char[] chars = new char[26];

        private MyString(String s) {
            for (int i = 0, l = s.length(); i < l; i++) {
                chars[s.charAt(i) - 'a']++;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MyString)) return false;
            MyString myString = (MyString) o;
            return Arrays.equals(chars, myString.chars);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(chars);
        }
    }
}
