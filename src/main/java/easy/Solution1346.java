package easy;

/**
 * @author zhangjun
 * @since 2022/7/4 12:51
 */
public class Solution1346 {
    public boolean checkIfExist(int[] arr) {
        int[] map = new int[2001];
        for (int i : arr) {
            map[i + 1000]++;
        }
        for (int i : arr) {
            int t = i * 2 + 1000;
            if (t >= 0 && t <= 2000 && (map[t] > 1 || (i != 0 && map[t] == 1))) {
                return true;
            }
        }
        return false;
    }
}
