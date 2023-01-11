package easy;

/**
 * @author zhangjun
 * @version 2023/1/11
 */
public class Solution2283 {
    public boolean digitCount(String num) {
        int [] map = new int [10];
        for(int i = 0,l = num.length(),t;i < l;i++){
            t = num.charAt(i) - '0';
            map[t]++;
        }
        for(int i = 0,l = num.length(),t;i < l;i++){
            if(map[i] != num.charAt(i) - '0'){
                return false;
            }
        }
        return true;
    }
}
