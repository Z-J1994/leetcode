package hard;

public class Solution488 {
    private final int[] hands = {0, 0, 0, 0, 0};

    private int result = -1;

    public int findMinStep(String board, String hand) {
        char[] chars = board.toCharArray();

        for (int i = 0; i < hand.length(); i++) {
            hands[map(hand.charAt(i))]++;
        }
        dfs(chars, 0, 0);
        return result;
    }


    private void dfs(char[] chars, int index, int count) {
        if (chars.length == 0 && (result == -1 || result > count)) {
            result = count;
            return;
        }
        if (index >= chars.length) {
            return;
        }
        char c = chars[index];
        char x = c;
        dfs(chars, index + 1, count);

        if (hands[map(x)] > 0) {
            hands[map(x)]--;

            char[] n;
            int l = index - 1;
            int r = index + 1;
            int left = l;
            int right = r;
            boolean unfinished = true;
            int t = 2;
            while (unfinished) {
                unfinished = false;
                if (l >= 0 && chars[l] == c) {
                    l--;
                    unfinished = true;
                    t++;
                }
                if (r < chars.length && chars[r] == c) {
                    r++;
                    unfinished = true;
                    t++;
                }
            }
            if (t >= 3) {
                while (t >= 3) {
                    t = 0;
                    left = l;
                    right = r;
                    if (l >= 0) {
                        c = chars[l];
                    } else if (r < chars.length) {
                        c = chars[r];
                    }
                    unfinished = true;
                    while (unfinished) {
                        unfinished = false;
                        if (l >= 0 && chars[l] == c) {
                            l--;
                            unfinished = true;
                            t++;
                        }
                        if (r < chars.length && chars[r] == c) {
                            r++;
                            unfinished = true;
                            t++;
                        }
                    }
                }

                int length = chars.length - right + left + 1;
                n = new char[length];
                if (length != 0) {
                    System.arraycopy(chars, 0, n, 0, left + 1);
                    System.arraycopy(chars, right, n, left + 1, chars.length - right);
                }
            } else {
                n = new char[chars.length + 1];
                System.arraycopy(chars, 0, n, 0, index + 1);
                n[index + 1] = c;
                System.arraycopy(chars, index + 1, n, index + 2, chars.length - (index + 1));
            }
            dfs(n, 0, count + 1);
            hands[map(x)]++;
        }

        if (index + 1 < chars.length && chars[index + 1] == c) {
            for (int i = 0; i < 5; i++) {
                char t = reverseMap(i);
                if (t != c && hands[i] > 0) {
                    hands[i]--;
                    char [] n = new char[chars.length + 1];
                    System.arraycopy(chars, 0, n, 0, index + 1);
                    n[index + 1] = t;
                    System.arraycopy(chars, index + 1, n, index + 2, chars.length - (index + 1));
                    dfs(n,0,count + 1);
                    hands[i]++;
                }
            }
        }
    }

    private int map(char c) {
        switch (c) {
            case 'R':
                return 0;
            case 'Y':
                return 1;
            case 'B':
                return 2;
            case 'G':
                return 3;
            case 'W':
                return 4;
        }
        throw new IllegalArgumentException();
    }

    private char reverseMap(int x) {
        switch (x) {
            case 0:
                return 'R';
            case 1:
                return 'Y';
            case 2:
                return 'B';
            case 3:
                return 'G';
            case 4:
                return 'W';
        }
        throw new IllegalArgumentException();
    }
}
