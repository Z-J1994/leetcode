package medium;

/**
 * @author zhangjun
 * @since 2024/1/11 13:30
 */
public class Solution2645 {
    public int addMinimum(String word) {
        int count = 0;
        int p = 'a';
        for (int i = 0, t, l = word.length(), pc = 'a'; i < l; i++) {
            char c = word.charAt(i);
            if ((t = c - p) >= 0) {
                count += t;
            } else {
//                count += 'c' - pc + (c - 'a');
                count += 2 + c - pc;
            }
//            p = (c + 1) % 'a' + 'a';
            p = (c + 1) % 'a' + 'a';
            pc = c;
        }
        if (p != 'a') {
//            count += 'c' - p + 1;
            count += 'd' - p;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2645 s = new Solution2645();
        System.out.println(s.addMinimum("b") == 2);
        System.out.println(s.addMinimum("aaa") == 6);
        System.out.println(s.addMinimum("abc") == 0);
        System.out.println(s.addMinimum("aaaabb") == 9);
        System.out.println(s.addMinimum("aaaaba") == 9);
    }
}
