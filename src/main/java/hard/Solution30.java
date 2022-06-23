package hard;

import java.util.*;

public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        int elementLength = words[0].length();
        int length = words.length * elementLength;
        if (length > s.length()) {
            return Collections.emptyList();
        }
        int mod = getCapacity(length);
        Map<String, Integer>[] usedMap = new Map[mod + 1];
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        char[] chars = s.toCharArray();
        Integer mc;
        int uc;
        for (int i = 0, l = length - elementLength; i < l; i++) {
            String key = new String(chars, i, elementLength);
            mc = map.get(key);
            if (mc != null) {
                usedMap[i] = new HashMap<>();
                usedMap[i].put(key, 1);
                for (int j = i % elementLength; j < i; j += elementLength) {
                    if (usedMap[j] != null) {
                        if (mc > (uc = usedMap[j].getOrDefault(key, 0))) {
                            usedMap[j].put(key, uc + 1);
                        } else {
                            usedMap[j] = null;
                        }
                    }
                }
            } else {
                for (int j = i % elementLength; j <= i; j += elementLength) {
                    usedMap[j] = null;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        int base = 0;
        for (int i = length - elementLength, l = chars.length - elementLength; i <= l; i++, base++) {
            String key = new String(chars, i, elementLength);
            mc = map.get(key);
            if (mc != null) {
                HashMap<String, Integer> temp = new HashMap<>();
                temp.put(key, 1);
                usedMap[i & mod] = temp;
                for (int j = base, index; j < i; j += elementLength) {
                    index = j & mod;
                    if (usedMap[index] != null) {
                        if (mc > (uc = usedMap[index].getOrDefault(key, 0))) {
                            usedMap[index].put(key, uc + 1);
                        } else {
                            usedMap[index] = null;
                        }
                    }
                }
            } else {
                for (int j = base; j <= i; j += elementLength) {
                    usedMap[j & mod] = null;
                }
            }
            if (usedMap[base & mod] != null) {
                result.add(base);
            }
        }
        return result;
    }

    private int getCapacity(int n) {
        n -= 1;
        n |= n >>> 16;
        n |= n >>> 8;
        n |= n >>> 4;
        n |= n >>> 2;
        n |= n >>> 1;
        return n;
    }

    public static void main(String[] args) {
        Solution30 s = new Solution30();
//        System.out.println(s.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
//        System.out.println(s.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
//        System.out.println(s.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
//        System.out.println(s.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
        System.out.println(s.findSubstring("mississippi", new String[]{"is"}));
    }
}
