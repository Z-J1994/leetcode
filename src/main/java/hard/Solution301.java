package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution301 {
    private Set<String> result = new HashSet<>();
    private String s;

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        if(left != 0 || right != 0){
            dfs(new Stack(s.length()), left, right, 0);
        }else{
            result.add(s);
        }
        return new ArrayList<>(result);
    }

    private void dfs(Stack stack, int left, int right, int index) {
        if (stack.right > stack.left) {
            return;
        }
        if (index == s.length()) {
            if (left == 0 && right == 0) {
                result.add(stack.toString());
            }
            return;
        }

        char c = s.charAt(index);
        int mark = 0;
        if (c == '(') {
            if (left > 0) {
                dfs(stack, left - 1, right, index + 1);
            }
            mark = 1;
            stack.left++;
        } else if (c == ')') {
            if (right > 0) {
                dfs(stack, left, right - 1, index + 1);
            }
            mark = 2;
            stack.right++;
        }
        stack.add(c);
        dfs(stack, left, right, index + 1);
        stack.removeLast();
        if(mark == 1){
            stack.left--;
        }else if(mark == 2){
            stack.right--;
        }
    }

    private static class Stack {

        private final char[] value;
        private int left;
        private int right;
        private int index = -1;

        public Stack(int capacity) {
            this.value = new char[capacity];
        }

        private char peek() {
            return value[index];
        }

        private void removeLast() {
            index--;
        }

        private void add(char element) {
            value[++index] = element;
        }

        private boolean isEmpty() {
            return index == -1;
        }

        @Override
        public String toString() {
            return new String(value, 0, index + 1);
        }
    }
}
