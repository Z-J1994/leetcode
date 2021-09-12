package medium;

/**
 * @author zhangjun
 * @version 2021/9/12
 */
public class Solution678 {
    public boolean checkValidString(String s) {
        int length = s.length();
        char [][] stack = new char [length][2];
        int top = -1;
        char general = 0;
        for(int i = 0;i < length;i++){
            char c = s.charAt(i);
            if(c == '*'){
                general++;
            }else if(c == '('){
                stack[++top][0] = c;
                stack[top][1] = general;
            }else{
                if(top >= 0){
                    top--;
                }else if(general > 0){
                    general--;
                }else{
                    return false;
                }
            }
        }

        for(int i = top;i >= 0;i--){
            if(general - (stack[i][1])  <= 0){
                return false;
            }
            general--;
        }

        return true;
    }
}
