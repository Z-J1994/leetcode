package easy;

/**
 * @author zhangjun
 * @version 2022/3/14
 */
public class Solution680 {
    public boolean validPalindrome(String s) {
        //假设1:要去除的数字在左边
        for(int i = 0,j = s.length() - 1,c = 0;i < j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                if(c++ != 0){
                    //假设1不成立,继续假设要去除的数字在右边
                    for(int l = 0,k = s.length() - 1,t = 0;l < k;l++,k--){
                        if(s.charAt(l) != s.charAt(k)){
                            if(t++ != 0){
                                return false;
                            }
                            l--;
                        }
                    }
                    return true;
                }
                j++;
            }
        }
        return true;
    }
}
