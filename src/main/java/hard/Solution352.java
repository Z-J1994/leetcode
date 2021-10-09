package hard;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2021/10/9
 */
public class Solution352 {
    private static class SummaryRanges {
        private int[][] data;
        private int size;
        private boolean modified = true;
        private int[][] show;

        public SummaryRanges() {
            data = new int[10][2];
            size = 0;
        }

        public void addNum(int val) {
            if (size > 0) {
                if (preProcess(val) || process(val)) {
                    modified = true;
                }
            } else {
                data[0] = new int[]{val, val};
                size++;
            }

        }

        public int[][] getIntervals() {
            if (modified) {
                show = Arrays.copyOf(data, size);
                modified = false;
            }
            return show;
        }


        private boolean preProcess(int val) {
            if (val < data[0][0]) {
                if (val + 1 == data[0][0]) {
                    data[0][0] = val;
                } else {
                    if (size == data.length) {
                        int[][] newData = new int[size << 1][2];
                        System.arraycopy(data, 0, newData, 1, size);
                        data = newData;
                    } else {
                        System.arraycopy(data, 0, data, 1, size);
                    }
                    data[0] = new int[]{val, val};
                    size++;
                }
                return true;
            }
            if (val > data[size - 1][1]) {
                if (val - 1 == data[size - 1][1]) {
                    data[size - 1][1] = val;
                } else {
                    if (size == data.length) {
                        data = Arrays.copyOf(data, size << 1);
                    }
                    data[size++] = new int[]{val, val};
                }
                return true;
            }
            return false;
        }

        private boolean process(int val) {
            int lo = 0, hi = size - 1;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;
                if (data[mid][1] < val) {
                    lo = mid + 1;
                } else if (data[mid][0] > val) {
                    hi = mid - 1;
                } else {
                    return false;
                }
            }

            if (data[hi][1] + 1 == val && data[lo][0] - 1 == val) {
                data[lo][0] = data[hi][0];
                System.arraycopy(data, lo, data, hi, size - lo);
                size--;
            } else if (data[hi][1] + 1 == val) {
                data[hi][1] = val;
            } else if (data[lo][0] - 1 == val) {
                data[lo][0] = val;
            } else {
                if (size == data.length) {
                    int[][] newData = new int[size << 1][2];
                    System.arraycopy(data, 0, newData, 0, hi + 1);
                    System.arraycopy(data, lo, newData, lo + 1, size - lo);
                    data = newData;
                } else {
                    System.arraycopy(data, lo, data, lo + 1, size - lo);
                }

                data[lo] = new int[]{val, val};
                size++;
            }
            return true;
        }
    }

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
}
