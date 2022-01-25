package hard;

/**
 * @author zhangjun
 * @version 2022/1/25
 */
public class Solution32 {
    public int longestValidParentheses(String s) {
        int length = s.length();
        int [] map = new int [length];
        int [] stack = new int[length];
        int top = -1;
        for(int i = 0;i < length;i++){
            char c = s.charAt(i);
            if(c == '('){
                stack[++top] = i;
            }else{
                if(top >= 0){
                    map[stack[top]] = 1;
                    --top;
                    map[i] = -1;
                }
            }
        }
        int max = 0;
        int l = 0;
        for(int i = 0;i < length;i++){
            if(map[i] == 1){
                l += 2;
            }
            else if(map[i] == 0){
                if(l > max){
                    max = l;
                }
                l = 0;
            }
        }
        return Math.max(max, l);
    }
}
