package easy;

/**
 * @author zhangjun
 * @since 2022/8/1 12:44
 */
public class Solution1374 {
    public String generateTheString(int n) {
        char [] data = new char[n];
        int i = 0;
        if((n & 1) == 0){
            data[i++] = 'a';
        }
        while(i < n){
            data[i++] = 'b';
        }
        return new String(data);
    }
}
