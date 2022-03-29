package medium;

public class Solution2024 {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int k1 = k;
        int lF = 0, lT = 0;
        int r = -1;
        int length = answerKey.length();
        int max = 0;
        int c;
        char[] chars = answerKey.toCharArray();
        while (++r < length) {
            if (chars[r] == 'T') {
                if (--k1 < 0) {
                    c = r - lF;
                    if (c > max) {
                        max = c;
                    }
                    while (chars[lF] != 'T') {
                        lF++;
                    }
                    k1++;
                    lF++;
                }
            } else {
                if (--k < 0) {
                    c = r - lT;
                    if (c > max) {
                        max = c;
                    }
                    while (chars[lT] != 'F') {
                        lT++;
                    }
                    k++;
                    lT++;
                }
            }
        }
        c = Math.max(r - lT, r - lF);
        if (c > max) {
            max = c;
        }
        return max;
    }

}
