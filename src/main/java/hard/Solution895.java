package hard;

import java.util.*;

public class Solution895 {

    private static class FreqStack {

        private final Map<Integer, Pair> map;
        private final Heap heap;

        private int offset = 0;

        public FreqStack() {
            map = new HashMap<>();
            heap = new Heap();
        }

        public void push(int val) {
            Pair pair = map.get(val);
            if (pair == null) {
                map.put(val, pair = new Pair(val));
                pair.deque.push(offset);
                heap.add(pair);
            } else {
                pair.deque.push(offset);
                pair.count++;
                heap.swim(pair.index);
            }
            offset++;
        }

        public int pop() {
            Pair pop = heap.pop();
            if(pop.count == 0){
                map.remove(pop.x);
            }
            return pop.x;
        }


        private static class Pair {
            private final int x;
            private int count;

            private int index;

            private final Deque<Integer> deque;

            public Pair(int x) {
                this.x = x;
                count = 1;
                deque = new ArrayDeque<>();
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Pair pair = (Pair) o;
                return x == pair.x;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x);
            }
        }

        private static class Heap {
            private Pair[] element;
            private int size;

            public Heap() {
                element = new Pair[16];
            }

            public void add(Pair pair) {
                if (size == element.length) {
                    grow(size << 1);
                }
                pair.index = size;
                element[size] = pair;
                swim(size++);
            }

            public Pair pop() {
                Pair p = element[0];
                p.deque.pop();
                if (--p.count == 0) {
                    element[0] = element[--size];
                    element[0].index = 0;
                }
                sink(0);
                return p;
            }

            public void swim(int x) {
                Pair value = element[x];
                int parent;
                while (x > 0 && greater(value, element[parent = (x - 1) >>> 1])) {
                    element[x] = element[parent];
                    element[x].index = x;
                    x = parent;
                }
                element[x] = value;
                element[x].index = x;
            }

            public void sink(int x) {
                Pair value = element[x];
                int child;
                while ((child = (x << 1) + 1) < size) {
                    if (child + 1 < size && greater(element[child + 1], element[child])) {
                        child++;
                    }
                    if (greater(value, element[child])) {
                        break;
                    }
                    element[x] = element[child];
                    element[x].index = x;
                    x = child;
                }
                element[x] = value;
                element[x].index = x;
            }

            private boolean greater(Pair a, Pair b) {
                return (a.count > b.count) || ((a.count == b.count) && a.deque.peek() > b.deque.peek());
            }

            private void grow(int newCapacity) {
                element = Arrays.copyOf(element, newCapacity);
            }
        }
    }
}
