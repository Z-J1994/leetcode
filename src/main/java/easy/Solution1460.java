package easy;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2020/09/24  22:33
 */
public class Solution1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target,arr);
    }
}
