package medium;

/**
 * @author zhangjun
 * @since 2022/8/31 13:01
 */
public class Solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[pushed.length];
        int top = -1;
        for (int i = 0, j = 0; j < popped.length; ) {
            if (top >= 0 && stack[top] == popped[j]) {
                --top;
                ++j;
            } else if(i < pushed.length){
                stack[++top] = pushed[i++];
            }else{
                ++j;
            }
        }
        return top == -1;
    }
}
