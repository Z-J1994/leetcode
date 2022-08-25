package medium;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhangjun
 * @since 2022/8/25 12:58
 */
public class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr.length <= k) {
            return new IntCycleList(arr);
        }
        IntCycleList list = new IntCycleList(k);
        int left = binarySearch(arr, x);
        int right = left + 1;
        while (list.size() != k && left >= 0 && right < arr.length) {
            if (x - arr[left] <= arr[right] - x) {
                list.addFirst(arr[left--]);
            } else {
                list.add(arr[right++]);
            }
        }

        while (list.size() != k && left >= 0) {
            list.addFirst(arr[left--]);
        }
        while (list.size() != k && right < arr.length) {
            list.add(arr[right++]);
        }
        return list;
    }
    private int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (hi == arr.length) {
            return hi - 1;
        }
        if (arr[hi] == target) {
            return hi;
        }
        if (hi > 0 && arr[hi] - target >= target - arr[hi - 1]) {
            return hi - 1;
        }
        return hi;
    }
    private static class IntCycleList extends AbstractList<Integer> {

        private final int[] element;

        private int head;

        private int tail;

        private final boolean flag;

        public IntCycleList(int capacity) {
            element = new int[capacity + 1];
            flag = false;
        }

        public IntCycleList(int[] element) {
            this.element = element;
            head = 0;
            tail = element.length;
            flag = true;
        }

        @Override
        public boolean add(Integer integer) {
            element[tail++] = integer;
            return true;
        }

        public void addFirst(Integer integer) {
            head = (head - 1 + element.length) % element.length;
            element[head] = integer;
        }

        @Override
        public Integer get(int index) {
            return element[(head + index) % element.length];
        }

        @Override
        public int size() {
            return tail >= head ? (tail - head) : tail + (element.length - head);
        }

        @Override
        public Iterator<Integer> iterator() {
            return flag ? new ArrayIterator() : new IntCycleListIterator(head, tail);
        }

        private class IntCycleListIterator implements Iterator<Integer> {

            private int head;

            private final int tail;

            public IntCycleListIterator(int head, int tail) {
                this.head = head;
                this.tail = tail;
            }

            @Override
            public boolean hasNext() {
                return tail != head;
            }

            @Override
            public Integer next() {
                int result = element[head];
                head = (head + 1) % element.length;
                return result;
            }
        }

        private class ArrayIterator implements Iterator<Integer> {

            private int head = 0;

            @Override
            public boolean hasNext() {
                return head != element.length;
            }

            @Override
            public Integer next() {
                return element[head++];
            }
        }
    }

    public static void main(String[] args) {
        Solution658 s = new Solution658();
        System.out.println(s.findClosestElements(new int[]{1, 3}, 1, 2));
        System.out.println(s.findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
        System.out.println(s.findClosestElements(new int[]{1,2,3,4,5}, 4, -1));
        System.out.println(s.findClosestElements(new int[]{1}, 1, 1));
    }
}
