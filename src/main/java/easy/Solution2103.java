package easy;

/**
 * @author zhangjun
 * @since 2023/11/2 12:47
 */
public class Solution2103 {

    public int countPoints(String rings) {
        int[] bitmap = new int[10];
        for (int i = 0; i < rings.length(); i++) {
            char c = rings.charAt(i++);
            if (c == 'R') {
                c = 1;
            } else if (c == 'G') {
                c = 2;
            } else {
                c = 4;
            }
            bitmap[rings.charAt(i) - '0'] |= c;
        }
        int result = 0;
        for (int i : bitmap) {
            if (i == 7) {
                result++;
            }
        }
        return result;
    }
}
