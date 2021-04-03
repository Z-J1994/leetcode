package hard;

/**
 * @author zhangjun
 * @date 2021/3/10
 */
public class Solution224 {
    public int calculate(String s) {
        int length = s.length();
        int [] stack = new int[length];
        int top = -1;
        stack[++top] = 1;

        int result = 0;
        int sign = 1;

        for(int i = 0;i < length;i++){
            int c = s.charAt(i);
            if(c == ' '){
                continue;
            }
            if(c == '-'){
                sign = -stack[top];
            }else if(c == '+'){
                sign = stack[top];
            }else if(c == ')'){
                --top;
            }else if(c == '('){
                stack[++top] = sign;
            }else{
                c -= 48;
                char t;
                while(i + 1 < length && (t = s.charAt(i + 1)) >= '0' && t <= '9'){
                    c = c * 10 + (t - 48);
                    i++;
                }
                result += sign * c;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution224 s = new Solution224();
        String s1 = "1 + 1";
        String s2 = " 2-1 + 2 ";
        String s3 = "(1+(4+5+2)-3)+(6+8)";
        String s4 = "123 + 345";
        String s5 = "  30";
        String s6 = "   (  3 ) ";
        String s7 = "-2+ 1";
        String s8 = "- (3 + (4 + 5))";
        System.out.println(s.calculate(s1) == 2);//2
        System.out.println(s.calculate(s2) == 3);//3
        System.out.println(s.calculate(s3) == 23);//23
        System.out.println(s.calculate(s4) == 468);//468
        System.out.println(s.calculate(s5) == 30);//30
        System.out.println(s.calculate(s6) == 3);//3
        System.out.println(s.calculate(s7) == -1);//-1
        System.out.println(s.calculate(s8) == -12);//-12
    }
}
