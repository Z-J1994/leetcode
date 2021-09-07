package easy;

/**
 * @author zhangjun
 * @version 2020/09/21  20:41
 */
public class Solution1221{

    public int balancedStringSplit(String s) {
        int count = 0;
        int c = 0;
        for(int i = 0,l = s.length();i < l;i++){
            if(s.charAt(i) == 'L'){
                c++;
            }else{
                c--;
            }
            if(c == 0){
                count++;
            }
        }
        return count;
    }

}
