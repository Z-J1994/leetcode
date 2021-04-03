package medium;

import java.util.*;

/**
 * @author zhangjun
 * @date 2021/3/23
 */
public class Solution341 {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    static class NestedIterator implements Iterator<Integer> {

        private Deque<Iterator<NestedInteger>> stack;
        private Integer nextInteger;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new ArrayDeque<>();
            stack.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            if(nextInteger != null){
                return nextInteger;
            }
            return stack.peek().next().getInteger();
        }

        @Override
        public boolean hasNext() {
            if(stack.isEmpty()){
                return false;
            }

            Iterator<NestedInteger> peek = stack.peek();
            if(!peek.hasNext()){
                stack.pop();
                return hasNext();
            }

            NestedInteger next = peek.next();
            if(next.isInteger()){
                nextInteger = next.getInteger();
                return true;
            }

            nextInteger = null;
            List<NestedInteger> list = next.getList();
            if(!list.isEmpty()){
                stack.push(list.iterator());
            }
            return hasNext();
        }
    }
}
