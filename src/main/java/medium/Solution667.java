package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangjun
 * @since 2022/9/8 13:03
 */
public class Solution667 {
    public int[] constructArray(int n, int k) {
        int[] answer = new int[n];
        int[] m = {1, n};
        int[] o = {1, -1};
        int i = 0;
        while (k-- > 0) {
            answer[i] = m[i & 1];
            m[i & 1] += o[i & 1];
            i++;
        }
        int t = m[(i + 1) & 1];
        int s = o[(i + 1) & 1];
        while (i < n) {
            answer[i++] = t;
            t += s;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution667 s = new Solution667();
//        int n = 10000;
//        int k = 56;

//        int n = 3;
//        int k = 1;

//        int n = 10;
//        int k = 3;


        int n = 3;
        int k = 2;
        int[] ints = s.constructArray(n, k);
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < ints.length; i++) {
            set.add(Math.abs(ints[i] - ints[i - 1]));
        }
        System.out.println(set.size() == k);
    }
}
