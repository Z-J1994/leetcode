package medium;

import java.util.HashMap;
import java.util.Map;

public class Solution397 {
    Map<Integer, Integer> dp = new HashMap<>();

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        Integer i = dp.get(n);
        if (i != null) {
            return i;
        }
        if ((n & 1) == 1) {
            int r = Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1;
            dp.put(n, r);
            return r;
        }
        int r = integerReplacement(n >>> 1) + 1;
        dp.put(n, r);
        return r;
    }
}
