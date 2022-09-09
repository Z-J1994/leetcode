package easy;

/**
 * @author zhangjun
 * @since 2022/9/9 13:06
 */
public class Solution1598 {
    public int minOperations(String[] logs) {
        int c = 0;
        for(String s : logs){
            if(s.equals("../")){
                if(c > 0){
                    c--;
                }
            }else if(!s.equals("./")){
                c++;
            }
        }
        return c;
    }
}
