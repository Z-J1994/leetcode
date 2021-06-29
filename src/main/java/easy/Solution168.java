package easy;

/**
 * @author zhangjun
 * @version 2021/6/29
 */
public class Solution168 {
    public String convertToTitle(int columnNumber) {
        int [] chars = new int [10];
        int i = 10;
        while(columnNumber > 0){
            int t = (columnNumber % 26);
            columnNumber /= 26;
            if(t > 0){
                t += 64;
            }else{
                t = 'Z';
                if(columnNumber % 26 != 0){
                    --columnNumber;
                }
            }
            chars[--i] = t;
        }
        return new String(chars,i,10 - i);
    }
}
