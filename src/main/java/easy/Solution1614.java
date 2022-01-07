package easy;

/**
 * @author zhangjun
 * @version 2022/1/7
 */
public class Solution1614 {
    public int maxDepth(String s) {
        int top = 0;
        int max = 0;
        for(int i = 0 ,l = s.length();i < l;i++){
            char c = s.charAt(i);
            if(c == '('){
                max = ++top > max ? top : max;
            }else if(c == ')'){
                --top;
            }
        }
        return max;
    }
}
