package medium;

/**
 * @author zhangjun
 * @version 2021/8/21
 */
public class Solution443 {
    public int compress(char[] chars) {
        int result = 0;
        char previous = 0;
        int count = 0;
        for(int i = 0,l = chars.length;i < l;i++){
            char c = chars[i];
            if(c == previous){
                count++;
            }else{
                if (count != 1) {
                    result += length(count, chars, result);
                }
                chars[result++] = c;
                count = 1;
            }
            previous = c;
        }
        if(count != 1){
            result += length(count,chars,result);
        }

        return result;
    }


    private int length(int n,char [] chars,int index){
        int count = 0;
        int t = n;
        while(n != 0){
            count++;
            n /= 10;
        }
        index += count;
        for(int i = t;i > 0;i /= 10){
            chars[--index] = (char)(i % 10 + 48);
        }

        return count;
    }
}
