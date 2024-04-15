package medium;

/**
 * @author zhangjun
 * @since 2024/4/15 12:53
 */
public class Solution1249 {
    public String minRemoveToMakeValid(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int[] indexes = new int[length];
        int top = -1;
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            if (c == '(') {
                indexes[++top] = i;
            } else if (c == ')') {
                if (top >= 0 && chars[indexes[top]] == '(') {
                    --top;
                } else {
                    indexes[++top] = i;
                }
            }
        }
        int slow = 0,fast = 0;
        for (int i = 0; i <= top; fast++) {
            if (fast != indexes[i]) {
                chars[slow++] = chars[fast];
            } else {
                ++i;
            }
        }
        while(fast < length){
            chars[slow++] = chars[fast++];
        }
        return new String(chars, 0, slow);
    }

    public static void main(String[] args) {
        Solution1249 s = new Solution1249();
        System.out.println(s.minRemoveToMakeValid("lee(t(c)o)de)").equals("lee(t(c)o)de"));
    }
}
