package easy;

public class Solution859 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int[] map = new int[26];
        char[] charS = s.toCharArray();
        char[] charG = goal.toCharArray();
        boolean hasSameElement = false;

        for (char c : charG) {
            if (++map[c - 97] == 2) {
                hasSameElement = true;
            }
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (charS[i] != charG[i]) {
                if (map[charS[i] - 97]-- <= 0 || ++count > 2) {
                    return false;
                }
            }
        }
        return count == 2 || (count == 0 && hasSameElement);
    }
}
