package medium;

import java.util.Iterator;
import java.util.List;

/**
 * @author zhangjun
 * @since 2024/1/27 13:32
 */
public class Solution2861 {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int max = 0;
        for (List<Integer> list : composition) {
            int lo = 0, hi = 0;
            for (Iterator<Integer> li = list.iterator(), si = stock.iterator(); li.hasNext(); ) {
                hi = Math.max(hi,si.next() + li.next());
            }
            hi += budget;
            while (lo < hi) {
                int mid = (lo + 1 + hi) >>> 1;
                if (calculate(list, stock, cost, mid) <= budget) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            max = Math.max(max, lo);
        }
        return max;
    }


    private long calculate(List<Integer> list, List<Integer> stock, List<Integer> cost, long num) {
        long costSum = 0;
        for (Iterator<Integer> li = list.iterator(), si = stock.iterator(), ci = cost.iterator(); li.hasNext(); ) {
            long cin = ci.next(), p = (li.next() * num - si.next());
            if (p > 0) {
                costSum += p * cin;
            }
        }
        return costSum;
    }

    public static void main(String[] args) {
        Solution2861 s = new Solution2861();
        System.out.println(s.maxNumberOfAlloys(3, 2, 15, List.of(List.of(1, 1, 1), List.of(1, 1, 10)), List.of(0, 0, 0), List.of(1, 2, 3)));
    }
}
