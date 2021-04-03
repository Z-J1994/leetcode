package easy;

/**
 * @author zhangjun
 * @version 2020/09/23  16:05
 */
public class Solution1309 {
    public String freqAlphabets(String s) {
        char [] chars = new char[s.length()];
        int size = 0;
        boolean marked = false;
        for(int i = 0;i < chars.length;i++,size++){
            char c = s.charAt(i);
            int t = c - '0';
            if(c == '#'){
                i -= 2;
                size -= 2;
                t =((s.charAt(i) - '0') * 10 + s.charAt(++i) - '0');
                i++;
            }
            chars[size] = (char)(t + 96);
        }
        return new String(chars,0,size);
    }
}
