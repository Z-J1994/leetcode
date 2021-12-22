package medium;

/**
 * @author zhangjun
 * @version 2021/12/22
 */
public class Solution686 {
    public int repeatedStringMatch(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        char[] aa = new char[a.length() << 1];
        for (int k = 0, l = ca.length; k < ca.length; k++) {
            aa[k] = ca[k];
            aa[k + l] = ca[k];
        }

        int i = 0;
        int j;
        while (true) {
            for (j = 0; j < cb.length; j++) {
                if (i + j == aa.length || aa[i + j] != cb[j]) {
                    break;
                }
            }
            if (j == cb.length) {
                return i + j > a.length() ? 2 : 1;
            }
            if (i + j == aa.length) {
                break;
            }
            ++i;
        }
        if (i == aa.length) {
            return -1;
        }
        i = (i + j) % ca.length;
        int answer = 3;
        while (true) {
            while (i < ca.length && j < cb.length) {
                if (ca[i] != cb[j]) {
                    return -1;
                }
                i++;
                j++;
            }
            if (j == cb.length) {
                break;
            }
            i %= ca.length;
            if (i == 0) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution686 s = new Solution686();
        System.out.println(s.repeatedStringMatch("a", "a") == 1);
        System.out.println(s.repeatedStringMatch("aabaa", "aaab") == 2);
        System.out.println(s.repeatedStringMatch("a", "aa") == 2);
        System.out.println(s.repeatedStringMatch("abcd", "cdabcdab") == 3);
        System.out.println(s.repeatedStringMatch("baa", "abaab") == 3);
    }
}
