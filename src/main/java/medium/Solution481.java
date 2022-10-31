package medium;

/**
 * @author zhangjun
 * @version 2022/10/31
 */
public class Solution481 {
    public int magicalString(int n) {
        if (n <= 2) {
            return 1;
        }
        int count = 1;
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 2;
        a[2] = 2;
        int i = 3;
        for (int j = 2,k; i < n; i++, j++) {
            k = (~a[i - 1]) & 3;
            a[i] = k;
            count += (a[i] & 1) << a[j] - 1;
            i += a[j] - 1;
            a[i] = k;
        }
        return i > n && a[n - 1] == 1 ? count - 1 : count;
    }

    public static void main(String[] args) {
        Solution481 s = new Solution481();
        System.out.println(s.magicalString(6));
        System.out.println(s.magicalString(8));
    }
}
