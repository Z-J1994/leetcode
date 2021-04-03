package easy;

/**
 * @author zhangjun
 * @version 2020/10/03  19:17
 */
public class Solution1332 {
    public int removePalindromeSub(String s) {
        if(s.length() == 0){
            return 0;
        }
        for(int i = 0,j = j = s.length() - 1;i < j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return 2;
            }
        }
        return 1;
    }
}
