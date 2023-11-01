package medium;

import utils.Parser;

public class Solution1375 {
    public int numTimesAllBlue(int[] flips) {
        int[] map = new int[flips.length + 1];
        int count = 0;
        int mask = 0;
        for (int i = 0; i < flips.length; i++) {
            map[flips[i]] = 1;
            mask -= (flips[i] - (i + 1)) >>> 31;
            mask += 1 - map[i + 1];
            count += 1 - ((-mask) >>> 31);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1375 s = new Solution1375();
        System.out.println(s.numTimesAllBlue(Parser.StringToIntArray("[3,2,4,1,5]")));
        System.out.println(s.numTimesAllBlue(Parser.StringToIntArray("[4,1,2,3]")));
        System.out.println(s.numTimesAllBlue(Parser.StringToIntArray("[1,2,44,4,5,6,32,8,9,10,3,50,13,33,45,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,7,14,34,35,36,37,38,39,40,41,42,43,11,15,46,47,48,12,49,51,52,53,54,55,56]")));
    }
}
