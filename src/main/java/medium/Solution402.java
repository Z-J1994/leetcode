package medium;

/**
 * @author zhangjun
 * @since 2024/4/11 13:04
 */
public class Solution402 {
    public String removeKdigits(String num, int k) {
        int length = num.length();
        if(k == length){
            return "0";
        }
        char [] monotonicStack = new char[length + 1];
        int top = 0;
        monotonicStack [top] = '0';
        for(int i = 0;i < length;i++){
            char c = num.charAt(i);
            while(k > 0 && monotonicStack[top] > c){
                --top;
                --k;
            }
            monotonicStack[++top] = c;
        }
        top -= k;
        int offset = 0;
        while(++offset < top && monotonicStack[offset] == '0');
        return new String(monotonicStack,offset,top - offset + 1);
    }
}
