package easy;

/**
 * @author zhangjun
 * @version 2020/09/24  22:33
 */
public class Solution1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] map = new int[1001];
        int c = 0;
        for (int i = 0; i < target.length; i++) {
            if (++map[target[i]] == 0) {
                c++;
            }
            if (map[arr[i]]-- == 0) {
                c--;
            }
        }
        return c == 0;
    }
}
