package medium;

import java.util.List;

public class Solution636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Triple[] stack = new Triple[(logs.size() >>> 1) + 1];
        int top = -1;
        stack[++top] = new Triple(logs.get(0));
        Triple p = stack[top];
        for (String s : logs) {
            Triple t = new Triple(s);
            result[stack[top].index] += t.time - p.time;
            if (t.end) {
                --top;
            } else {
                stack[++top] = t;
            }
            p = t;
        }
        return result;
    }

    private static class Triple {
        private final int index;
        private final boolean end;
        private final int time;

        private Triple(String s) {
            int number = 0;
            int i = 0;
            for (char c; i < s.length() && (c = s.charAt(i)) != ':'; i++) {
                number = number * 10 + (c - '0');
            }
            this.index = number;
            if (s.charAt(++i) == 's') {
                i += 6;
                end = false;
            } else {
                i += 4;
                end = true;
            }
            number = 0;
            while (i < s.length()) {
                number = number * 10 + (s.charAt(i) - '0');
                i++;
            }
            if (end) {
                this.time = number;
            } else {
                //开始时间向前偏移一个单位,便于计算
                this.time = number - 1;
            }
        }
    }
}
