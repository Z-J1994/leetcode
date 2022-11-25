package medium;

import java.util.Arrays;

public class Solution809 {
    public int expressiveWords(String s, String[] words) {
        int ol = s.length();
        char[][] pattern = compact(s);
        int count = 0;
        for (String word : words) {
            if (word.length() <= ol && match(pattern, word)) {
                count++;
            }
        }
        return count;
    }

    private char[][] compact(String s) {
        char[][] chars = new char[s.length()][2];
        for (int i = 0, l = s.length(); i < l; i++) {
            chars[i][0] = s.charAt(i);
        }
        int left = 0, right = 1, t = 0, offset = 0;
        while (right < chars.length) {
            if (chars[left][0] == chars[right][0]) {
                if (++t == 2) {
                    offset += 2;
                    chars[right - offset][1] = 2;
                } else if (t > 2) {
                    offset++;
                    chars[right - offset][1]++;
                }
            } else {
                t = 0;
            }
            chars[right - offset][0] = chars[right][0];
            left++;
            right++;
        }
        return Arrays.copyOf(chars, right - offset);
    }

    private boolean match(char[][] pattern, String target) {
        if (target.length() < pattern.length) {
            return false;
        }
        char p = ' ';
        int j = 0, l = target.length(), t = pattern[0][1];
        for (int i = 0; j < l && i < pattern.length; j++) {
            char ct = target.charAt(j);
            if (ct == pattern[i][0]) {
                p = pattern[i][0];
                t = pattern[i][1];
                i++;
            } else if (ct != p || --t < 0) {
                return false;
            }
        }
        if (l - j > t) {
            return false;
        }
        while (j < l && target.charAt(j++) == p) ;
        return j == l;
    }

    public static void main(String[] args) {
        Solution809 s = new Solution809();
        System.out.println(s.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}) == 1);
        System.out.println(s.expressiveWords("zzzzzyyyyy", new String[]{"zzyy", "zy", "zyy"}) == 3);
        System.out.println(s.expressiveWords("hehehe", new String[]{"he"}) == 0);
        System.out.println(s.expressiveWords("heeelllooo", new String[]{"hellllo"}) == 0);
        System.out.println(s.expressiveWords("dddiiiinnssssssoooo", new String[]{"dinnssoo", "ddinso", "ddiinnso", "ddiinnssoo", "ddiinso", "dinsoo", "ddiinsso", "dinssoo", "dinso"}) == 3);
        System.out.println(s.expressiveWords("vvvppppeeezzzzztttttkkkkkkugggggbbffffffywwwwwwbbbccccddddddkkkkksssppppddpzzzzzhhhhbbbbbmmmy", new String[]{"vvpeezztkkugbbffywwbccdkkspddpzzhbmmyy"}) == 0);
        System.out.println(s.expressiveWords("pppoooollwwjjjjmsssnnnnpppggggxxvvvrrrriiiaaajcppppkkuaaassssnnncmmmmloonssllllxxxapvxennmmmpxxxdddd", new String[]{"pollwwjjjjmssnnnpggxxvvvriiiaaajcpppkkuasnnncmmmloonssllxxxapvxennmpxddd"}) == 1);
    }

}
