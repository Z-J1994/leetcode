package medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution388 {

    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        int length = 0;
        int result = 0;
        char c;
        boolean file = false;
        for (int i = 0, l = input.length(), tCount = -1; i < l; i++) {
            switch (input.charAt(i)) {
                case '\n':
                    if (file) {
                        result = Math.max(result, length + stack.size());
                    }
                    tCount = 0;
                    file = false;
                    break;
                case '\t':
                    tCount++;
                    break;
                case '.':
                    file = true;
                    length++;
                    break;
                default:
                    if (tCount > stack.size()) {
                        stack.push(length);
                        tCount = -1;
                    } else if (tCount != -1) {
                        while (tCount != stack.size()) {
                            stack.pop();
                        }
                        if (stack.isEmpty()) {
                            length = 0;
                        } else {
                            length = stack.getFirst();
                        }
                        tCount = -1;
                    }
                    length++;
            }
        }
        if (file) {
            result = Math.max(result, length + stack.size());
        }
        return result;
    }

    public static void main(String[] args) {
        Solution388 s = new Solution388();
        System.out.println(s.lengthLongestPath("a\n\tb\n\t\tc.txt\n\taaaa.txt") == 10);
        System.out.println(s.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext") == 20);
        System.out.println(s.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext") == 32);
        System.out.println(s.lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt") == 12);
        System.out.println(s.lengthLongestPath("a") == 0);
    }
}
