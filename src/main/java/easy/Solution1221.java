package easy;

/**
 * @author zhangjun
 * @version 2020/09/21  20:41
 */
public class Solution1221{

    public int balancedStringSplit(String s) {
        char [] chars = s.toCharArray();
        int count = 0;
        int l = 0;
        int r = 0;
        for(int i = 0;i < chars.length;i++){
            if(chars[i] == 'R'){
                r++;
            } else if(chars[i] == 'L'){
                l++;
            }
            if(l == r){
                count++;
                l = 0;
                r = 0;
            }
        }

        if(l != r){
            return 0;
        }

        return count;
    }

}
