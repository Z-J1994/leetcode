package easy;

/**
 * @author zhangjun
 * @version 2021/10/4
 */
public class Solution482 {
    public String licenseKeyFormatting(String s, int k) {
        char [] chars = new char[s.length() + (s.length() / k) + 1];
        int l = chars.length - 1;
        int index = l;

        for(int i = s.length() - 1,count = 0;i >= 0;i--){
            char c = s.charAt(i);
            if(c == '-'){
                continue;
            }
            if(count != 0 && count % k == 0){
                chars[index--] = '-';
            }
            if(c >= 'a' && c <= 'z'){
                c -= 32;
            }
            chars[index--] = c;
            count++;
        }
        index++;
        return new String(chars,index,l - index + 1);
    }
}
