package easy;

/**
 * @author zhangjun
 * @version 2022/1/7
 */
public class Solution1614 {
    public int maxDepth(String s) {
        int max = 0;
        for(int i = 0,j = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                if(++j > max){
                    max = j;
                }
            }else if(c ==')'){
                --j;
            }
        }
        return max;
    }
}
