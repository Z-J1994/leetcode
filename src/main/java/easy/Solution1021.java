package easy;

/**
 * @author zhangjun
 * @version 2020/09/22  21:12
 */
public class Solution1021 {

    public String removeOuterParentheses(String S) {
        int l = 0;
        int r = 0;
        int mark = 0;
        char [] chars = S.toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i = 0;i < S.length();i++){
            char c = chars[i];
            if(c == '('){
                l++;
            }else {
                r++;
                if(l == r){
                    result.append(chars,mark + 1,l + r - 2);
                    l = 0;
                    r = 0;
                    mark = i + 1;
                }
            }
        }
        return result.toString();
    }


}
