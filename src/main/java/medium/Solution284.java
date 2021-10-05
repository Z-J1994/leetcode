package medium;

import java.util.Iterator;

/**
 * @author zhangjun
 * @version 2021/10/5
 */
public class Solution284 {

    private static class PeekingIterator implements Iterator<Integer> {

        private Iterator<Integer> iterator;
        private Integer next;
        private boolean hasNext;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            if (hasNext = iterator.hasNext()) {
                next = iterator.next();
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer result = next;
            if (hasNext = iterator.hasNext()) {
                next = iterator.next();
            }
            return result;
        }

        @Override
        public boolean hasNext() {
            return hasNext;
        }
    }

}
