package easy;

/**
 * @author zhangjun
 * @version 2022/3/24
 */
public class Solution806 {
    public int[] numberOfLines(int[] widths, String s) {
        int rowCount = 1;
        int mod = 0;
        for(int i = 0,l = s.length(),t;i < l;i++){
            t = widths[s.charAt(i) - 97];
            if(mod + t >100){
                rowCount++;
                mod = t;
            }else{
                mod += t;
            }
        }
        return new int[]{rowCount,mod};
}
