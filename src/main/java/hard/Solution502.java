package hard;

/**
 * @author zhangjun
 * @version 2021/9/8
 */
public class Solution502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        data = new int[16];
        size = 0;
        int length = profits.length - 1;
        quickSort(0, length, profits, capital);

        int limit = -1;

        while (++limit <= length && capital[limit] <= w) {
            add(profits[limit]);

        }
        if (size <= 0) {
            return w;
        }
        w += pop();

        while (--k > 0) {
            while (limit <= length && capital[limit] <= w) {
                add(profits[limit++]);
            }
            if(size <= 0){
                return w;
            }
            w += pop();
        }
        return w;
    }


    private int size;
    private int[] data;

    private void add(int element) {
        if (size == data.length) {
            grow((size << 1));
        }
        data[size] = element;
        swim(size++);
    }

    private void swim(int child) {
        int parent = (child - 1) >>> 1;
        int childValue = data[child];
        while (child > 0 && data[parent] < childValue) {
            data[child] = data[parent];
            child = parent;
            parent = (child - 1) >>> 1;
        }
        data[child] = childValue;
    }

    private int pop() {
        int result = data[0];
        data[0] = data[--size];
        sink(0);
        return result;
    }

    private void sink(int parent) {
        int child = (parent << 1) + 1;
        int parentValue = data[parent];
        while (child < size) {
            if (child + 1 < size && data[child] < data[child + 1]) {
                child++;
            }
            if (data[child] <= parentValue) {
                break;
            }
            data[parent] = data[child];
            parent = child;
            child = (parent << 1) + 1;
        }
        data[parent] = parentValue;
    }

    private void grow(int length) {
        int[] newData = new int[length];
        for (int i = 0, l = data.length; i < l; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void quickSort(int lo, int hi, int[] profits, int[] capital) {
        if (lo >= hi) {
            return;
        }
        int p = mid(lo, hi, profits, capital);
        quickSort(lo, p - 1, profits, capital);
        quickSort(p + 1, hi, profits, capital);
    }

    private int mid(int lo, int hi, int[] profits, int[] capital) {
        int mid = (lo + hi) >>> 1;
        int large = lo;
        if (capital[large] < capital[mid]) {
            large = mid;
        }

        if (capital[large] > capital[hi]) {
            swap(large, hi, capital);
            swap(large, hi, profits);
        }
        if (capital[lo] < capital[mid]) {
            swap(lo, mid, capital);
            swap(lo, mid, profits);
        }
        return partition(lo, hi, profits, capital);
    }

    private int partition(int lo, int hi, int[] profits, int[] capital) {
        int v = capital[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (capital[++i] < v) ;
            while (capital[--j] > v) ;
            if (i >= j) {
                break;
            }
            swap(i, j, profits);
            swap(i, j, capital);
        }
        capital[lo] = capital[j];
        capital[j] = v;
        swap(lo, j, profits);
        return j;
    }

    private void swap(int i, int j, int[] data) {
        int t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
