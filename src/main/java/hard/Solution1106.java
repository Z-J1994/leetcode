package hard;

public class Solution1106 {
    public boolean parseBoolExpr(String expression) {
        char [] stack = new char[expression.length()];
        int top = -1,h = 't' + 'f';
        char c;
        for(int i = 0;i < stack.length;i++){
            c = expression.charAt(i);
            if(c == ')'){
                int t = top;
                while(stack[--t] == 't' || stack[t] == 'f');
                if(stack[t] == '!'){
                    stack[t] = (char) (h - stack[top]);
                }else if(stack[t] == '&'){
                    stack[t] = and(stack,t + 1,top);
                }else{
                    stack[t] = or(stack,t + 1,top);
                }
                top = t;
            }else if(c != ',' && c != '('){
                stack[++top] = c;
            }
        }
        if(stack[0] == '!'){
            stack[0] = (char) (h - stack[top]);
        }else if(stack[0] == '&'){
            stack[0] = and(stack,  1,top);
        }else if(stack[0] == '|'){
            stack[0] = or(stack, 1,top);
        }
        return stack[0] == 't';
    }

    private char and(char [] element,int start,int end){
        boolean a = true;
        while(start <= end){
            a &= element[start++] == 't';
        }
        return a ? 't' : 'f';
    }

    private char or(char [] element,int start,int end){
        boolean a = false;
        while(start <= end){
            a |= element[start++] == 't';
        }
        return a ? 't' : 'f';
    }

    public static void main(String[] args) {
        Solution1106 s = new Solution1106();
        System.out.println(!s.parseBoolExpr("&(|(f))"));
        System.out.println(s.parseBoolExpr("|(f,f,f,t)"));
        System.out.println(s.parseBoolExpr("!(&(f,t))"));
    }
}
