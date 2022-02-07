package medium;

/**
 * @author zhangjun
 * @version 2022/2/7
 */
public class Solution1405 {
    private int a;
    private int b;
    private int c;
    private char[] chars;
    private int index;

    public String longestDiverseString(int a, int b, int c) {
        int length = a + b + c;
        this.a = a;
        this.b = b;
        this.c = c;
        index = 0;
        chars = new char[a + b + c];
        int p = select(-1);
        while (p != -1 && index < length) {
            p = select(p);
        }
        return new String(chars, 0, index);
    }

    private int select(int p) {
        if (a >= b && a >= c) {
            if (p == 0) {
                if (b == 0 && c == 0) {
                    return -1;
                }
                if (b >= c) {
                    b -= 1;
                    fill('b', 1);
                    return 1;
                }
                c -= 1;
                fill('c', 1);
                return 2;
            }
            if (a >= 2) {
                a -= 2;
                fill('a', 2);
            } else {
                a -= 1;
                fill('a', 1);
            }
            return 0;
        }
        if (b >= a && b >= c) {
            if (p == 1) {
                if (a == 0 && c == 0) {
                    return -1;
                }
                if (a >= c) {
                    a -= 1;
                    fill('a', 1);
                    return 0;
                }
                c -= 1;
                fill('c', 1);
                return 2;
            }
            if (b >= 2) {
                b -= 2;
                fill('b', 2);
            } else {
                b -= 1;
                fill('b', 1);
            }
            return 1;
        }
        if (p == 2) {
            if (a == 0 && b == 0) {
                return -1;
            }
            if (a >= b) {
                a -= 1;
                fill('a', 1);
                return 0;
            }
            b -= 1;
            fill('b', 1);
            return 1;
        }
        if (c >= 2) {
            c -= 2;
            fill('c', 2);
        }else{
            c -= 1;
            fill('c', 1);
        }
        return 2;
    }

    private void fill(char c, int count) {
        while (index < chars.length && count-- > 0) {
            chars[index++] = c;
        }
    }

    public static void main(String[] args) {
        Solution1405 s = new Solution1405();
        System.out.println(s.longestDiverseString(1, 1, 7));
        System.out.println(s.longestDiverseString(2, 2, 1));
        System.out.println(s.longestDiverseString(7, 1, 0));
        System.out.println(s.longestDiverseString(1, 1, 0));
        System.out.println(s.longestDiverseString(1, 1, 1));
        System.out.println(s.longestDiverseString(1, 0, 1));
        System.out.println(s.longestDiverseString(0, 1, 1));
        System.out.println(s.longestDiverseString(0, 8, 11));
    }
}
