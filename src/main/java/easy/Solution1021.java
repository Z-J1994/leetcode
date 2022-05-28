package easy;

/**
 * @author zhangjun
 * @version 2020/09/22  21:12
 */
public class Solution1021 {
    public String removeOuterParentheses(String s) {
        int length = s.length();
        char [] chars = new char[length];
        int index = 0;
        for(int i = 0,leftCount = 0;i < length;i++){
            if(s.charAt(i) == '('){
                if(leftCount++ != 0){
                    chars[index++] = '(';
                }
            }else{
                if(--leftCount != 0){
                    chars[index++] = ')';
                }
            }
        }
        return new String(chars,0,index);
    }
}
