package hard;

/**
 * @author zhangjun
 * @since 2022/9/6 13:14
 */
public class Solution828 {

    public int uniqueLetterString(String s) {
        int[][] list = new int[26][2];
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            list[i][0] = -1;
            list[i][1] = -1;
        }
        for (int i = 0, p = 0; i < s.length(); i++) {
            int[] indexed = list[s.charAt(i) - 65];
            p = i - indexed[1] + p - (indexed[1] - indexed[0]);
            sum += p;
            indexed[0] = indexed[1];
            indexed[1] = i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution828 s = new Solution828();
        System.out.println(s.uniqueLetterString("ABC") == 10);
        System.out.println(s.uniqueLetterString("ABA") == 8);
        System.out.println(s.uniqueLetterString("LE") == 4);
        System.out.println(s.uniqueLetterString("LEE") == 6);
        System.out.println(s.uniqueLetterString("LEET") == 12);
        System.out.println(s.uniqueLetterString("LEETC") == 23);
        System.out.println(s.uniqueLetterString("LEETCO") == 40);
        System.out.println(s.uniqueLetterString("LEETCOD") == 64);
        System.out.println(s.uniqueLetterString("LEETCODE") == 92);
        System.out.println(s.uniqueLetterString("ABAB") == 12);
        System.out.println(s.uniqueLetterString("ABABA") == 16);
        System.out.println(s.uniqueLetterString("ABABAB") == 20);
        System.out.println(s.uniqueLetterString("ABABABA") == 24);
        System.out.println(s.uniqueLetterString("ABABABAB") == 28);
        System.out.println(s.uniqueLetterString("ABABABABA") == 32);
        System.out.println(s.uniqueLetterString("ABABABABAB") == 36);
        System.out.println(s.uniqueLetterString("ABABABABABA") == 40);
        System.out.println(s.uniqueLetterString("ABABABABABABABABABABABABABABBBABAB") == 133);
    }
}
