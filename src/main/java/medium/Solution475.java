package medium;

public class Solution475 {
    public int findRadius(int[] houses, int[] heaters) {
        quickSort(heaters, 0, heaters.length - 1);
        quickSort(houses, 0, houses.length - 1);

        int radius = (heaters[0] > houses[0]) ? heaters[0] - houses[0] : 0;

        for (int i = 1, from = 0; i < heaters.length; i++) {
            int r = (heaters[i] - heaters[i - 1]) / 2;
            if (radius < r) {
                int t = heaters[i - 1];
                while (houses[from] < t) {
                    if (++from == houses.length) {
                        return radius;
                    }
                }
                int max = 0;
                int x;
                while ((x = (houses[from] - t)) <= r) {
                    if (x > max) {
                        max = x;
                    }
                    if (++from == houses.length) {
                        return Math.max(max, radius);
                    }
                }
                if (max > radius) {
                    radius = max;
                }
                if (houses[from] < heaters[i] && (max = (heaters[i] - houses[from])) > radius) {
                    radius = max;
                }
            }
        }

        int t = (houses[houses.length - 1] - heaters[heaters.length - 1]);
        if (t > radius) {
            radius = t;
        }
        return radius;
    }

    private void quickSort(int[] data, int lo, int hi) {
        if (lo < hi) {
            int pivot = random(data, lo, hi);
            quickSort(data, lo, pivot - 1);
            quickSort(data, pivot + 1, hi);
        }
    }

    private int random(int[] data, int lo, int hi) {
        int mid = (lo + hi) >>> 1;
        int minValue = data[lo];
        int midValue = data[mid];
        int maxValue = data[hi];

        if (maxValue < minValue) {
            int t = maxValue;
            maxValue = minValue;
            minValue = t;
        }

        if (maxValue < midValue) {
            int t = maxValue;
            maxValue = midValue;
            midValue = t;
        }

        if (midValue < minValue) {
            int t = midValue;
            midValue = minValue;
            minValue = t;
        }
        data[lo] = midValue;
        data[mid] = minValue;
        data[hi] = maxValue;
        return partition(data, lo, hi);
    }

    private int partition(int[] data, int lo, int hi) {
        int v = data[lo];
        int i = lo;
        int j = hi;
        while (true) {
            while (data[++i] < v) ;
            while (data[--j] > v) ;
            if (i >= j) {
                break;
            }
            int t = data[i];
            data[i] = data[j];
            data[j] = t;
        }
        data[lo] = data[j];
        data[j] = v;
        return j;
    }
}
