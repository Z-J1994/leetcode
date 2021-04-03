package medium;

/**
 * @author zhangjun
 * @date 2021/3/20
 */
public class Solution150 {
    public int evalRPN(String[] tokens) {
        int length = tokens.length;

        int [] stack = new int[length];
        int top = -1;

        for(int i = 0;i < length;i++){
            String s = tokens[i];
            if(s.length() > 1){
                int sign = 1;
                int j = 0;
                if(s.charAt(j) == '-'){
                    sign = -1;
                    j++;
                }
                int sum = 0;
                for(int l = s.length();j < l;j++){
                    sum = sum * 10 + (s.charAt(j) - 48);
                }
                stack[++top] = sign * sum;
            }else{
                int result;
                char c = s.charAt(0);
                switch(c){
                    case '+':result = stack[top--] + stack[top--];break;
                    case '-':
                        result = stack[top--];
                        result = stack[top--] - result
                        ;break;
                    case '*':result = stack[top--] * stack[top--];break;
                    case '/':
                        result = stack[top--];
                        result = stack[top--] / result;
                        break;
                    default :result = c - 48;
                }
                stack[++top] = result;
            }
        }
        return stack[0];
    }
}
