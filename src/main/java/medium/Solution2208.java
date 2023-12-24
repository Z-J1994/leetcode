package medium;

import utils.Parser;

/**
 * @author zhangjun
 * @since 2023/12/20 12:28
 */
public class Solution2208 {

    private long[] heap;

    public int halveArray(int[] nums) {
        heap = new long[nums.length];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            long l = (long) nums[i] << 20;
            heap[i] = l;
            sum += l;
        }
        for (int i = nums.length / 2; i >= 0; i--) {
            heapIFY(i);
        }
        long half = sum >>> 1;
        int i = 0;
        while (sum > half) {
            long h = heap[0] / 2;
            sum -= h;
            heap[0] = h;
            sink(0);
            i++;
        }
        return i;
    }

    private void heapIFY(int parent) {
        int max = parent;
        int child = (parent << 1) + 1;
        if (child < heap.length && heap[max] < heap[child]) {
            max = child;
        }
        if (++child < heap.length && heap[max] < heap[child]) {
            max = child;
        }
        if (max != parent) {
            long t = heap[max];
            heap[max] = heap[parent];
            heap[parent] = t;
            heapIFY(max);
        }
    }

    private void sink(int parent) {
        long value = heap[parent];
        int child;
        while ((child = (parent << 1) + 1) < heap.length) {
            if (child + 1 < heap.length && heap[child] < heap[child + 1]) {
                ++child;
            }
            if (value >= heap[child]) {
                break;
            }
            heap[parent] = heap[child];
            parent = child;
        }
        heap[parent] = value;
    }

    public static void main(String[] args) {
        Solution2208 s = new Solution2208();
        System.out.println(s.halveArray(Parser.StringToIntArray("[6,58,10,84,35,8,22,64,1,78,86,71,77]")) == 9);
    }
}
