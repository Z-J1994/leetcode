package medium;

import java.util.List;

/**
 * @author zhangjun
 * @version 2022/1/21
 */
public class Solution1306 {
    public boolean canReach(int[] arr, int start) {
        int[] queue = new int[arr.length];
        int head = 0;
        int tail = 0;
        queue[tail++] = start;
        boolean[] visited = new boolean[arr.length];
        visited[start] = true;
        while (head != tail) {
            int t = queue[head++];
            if (arr[t] == 0) {
                return true;
            }
            if (t - arr[t] >= 0 && !visited[t - arr[t]]) {
                queue[tail++] = t - arr[t];
                visited[t - arr[t]] = true;
            }
            if (t + arr[t] < arr.length && !visited[t + arr[t]]) {
                queue[tail++] = t + arr[t];
                visited[t + arr[t]] = true;
            }
        }
        return false;
    }
}
