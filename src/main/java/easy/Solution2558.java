package easy;

/**
 * @author zhangjun
 * @since 2023/10/28 13:47
 */
public class Solution2558 {
    public long pickGifts(int[] gifts, int k) {
        buildHeap(gifts);
        for (int i = 0; i < k && gifts[0] > 1; i++) {
            gifts[0] = (int) Math.sqrt(gifts[0]);
            sink(gifts, 0);
        }
        long sum = 0;
        for (int gift : gifts) {
            sum += gift;
        }
        return sum;
    }

    private static void sink(int[] gifts, int i) {
        int child = (i << 1) + 1;
        int v = gifts[i];
        while (child < gifts.length) {
            if (child + 1 < gifts.length && gifts[child] < gifts[child + 1]) {
                child++;
            }
            if (gifts[child] < v) {
                break;
            }
            gifts[i] = gifts[child];
            i = child;
            child = (i << 1) + 1;
        }
        gifts[i] = v;
    }

    private static void buildHeap(int[] gifts) {
        for (int i = (gifts.length - 1) >> 1; i >= 0; i--) {
            sink(gifts, i);
        }
    }
}
