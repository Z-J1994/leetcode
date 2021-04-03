package easy;

/**
 * @author zhangjun
 * @version 2020/09/26  14:34
 */
public class Solution1347 {

    public String generateTheString(int n) {
        char [] chars = new char[n];
        int i = 0;
        if(n % 2 == 0){
            chars[i++] = 'a';
        }
        for(;i < n;i++){
            chars[i] = 'b';
        }
        return new String(chars);
    }

}
