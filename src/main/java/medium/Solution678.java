package medium;

/**
 * @author zhangjun
 * @version 2021/9/12
 */
public class Solution678 {
    public boolean checkValidString(String s) {
        int length = s.length();
        byte [] stack = new byte [length];
        int top = -1;
        byte general = 0;
        for(int i = 0;i < length;i++){
            char c = s.charAt(i);
            if(c == '*'){
                general++;
            }else if(c == '('){
                stack[++top] = general;
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
            if(general <= stack[i]){
                return false;
            }
            general--;
        }
        return true;
    }
}
