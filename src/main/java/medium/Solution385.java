package medium;

import java.util.List;

public class Solution385 {

    private int from;

    public NestedInteger deserialize(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] != '[') {
            int t = 0;
            int sign = 1;
            if(chars[0] == '-'){
                sign = -1;
                from++;
            }
            while (from < chars.length) {
                t = t * 10 + chars[from++] - '0';
            }
            return new NestedInteger(t * sign);
        }
        from = 1;
        return dfs(s.toCharArray());
    }

    private NestedInteger dfs(char[] chars) {
        NestedInteger n = new NestedInteger();
        char c;
        Integer t = null;
        int sign = 1;
        while (from < chars.length) {
            c = chars[from++];
            if (c == '[') {
                n.add(dfs(chars));
            } else if (c == ']') {
                if (t != null) {
                    n.add(new NestedInteger(t * sign));
                }
                return n;
            } else if (c == ',') {
                if (t != null) {
                    n.add(new NestedInteger(t * sign));
                }
                t = null;
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else {
                if (t == null) {
                    t = 0;
                }
                t = t * 10 + (c - '0');
            }
        }
        return n;
    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public static class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {

        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {

        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return false;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return 0;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {

        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {

        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return null;
        }
    }


    public static void main(String[] args) {
        Solution385 s = new Solution385();
        s.deserialize("[324,325]");
    }
}
