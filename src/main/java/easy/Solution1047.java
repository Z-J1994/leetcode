package easy;

import java.util.Arrays;

/**
 * @author zhangjun
 * @version 2020/10/01  21:38
 */
public class Solution1047 {


    public String removeDuplicates(String S) {
        int length = S.length();
        char [] chars = S.toCharArray();
        int index = 0;

        for(int i = 1;i < length;i++){
            if(index != -1 && chars[index] == chars[i]){
                --index;
            }else{
                chars[++index] = chars[i];
            }
        }
        return new String(chars,0,index + 1);
    }

}
