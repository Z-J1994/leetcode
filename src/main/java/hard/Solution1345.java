package hard;

import java.util.*;

/**
 * @author zhangjun
 * @version 2022/1/21
 */
public class Solution1345 {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.get(arr[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(arr[i], list);
            }
            list.add(i);
        }

        int[] queue = new int[arr.length];
        int head = 0;
        int tail = 0;
        queue[tail++] = 0;
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        int count = 0;
        int size = 1;
        while (head != tail) {
            int t = queue[head++];
            if (t == arr.length - 1) {
                return count;
            }
            if (t > 0 && !visited[t - 1]) {
                queue[tail++] = t - 1;
                visited[t - 1] = true;
            }
            if (t + 1 < arr.length && !visited[t + 1]) {
                queue[tail++] = t + 1;
                visited[t + 1] = true;
            }
            List<Integer> l = map.get(arr[t]);
            if (l != null) {
                for (int i : l) {
                    if (i != t && !visited[i]) {
                        queue[tail++] = i;
                        visited[i] = true;
                    }
                }
                map.remove(arr[t]);
            }
            if (--size == 0) {
                size = tail - head;
                ++count;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1345 s = new Solution1345();
        System.out.println(s.minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}) == 3);
        System.out.println(s.minJumps(new int[]{7}) == 0);
        System.out.println(s.minJumps(new int[]{7,6,9,6,9,6,9,7}) == 1);
        System.out.println(s.minJumps(new int[]{6,1,9}) == 2);
        System.out.println(s.minJumps(new int[]{11,22,7,7,7,7,7,7,7,22,13}) == 3);
        int[] data = new int[100000];
        System.out.println(s.minJumps(data) == 1);
    }
}
