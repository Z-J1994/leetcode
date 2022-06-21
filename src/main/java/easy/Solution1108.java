package easy;

/**
 * @author zhangjun
 * @version 2020/09/19  13:58
 */
public class Solution1108 {
    public String defangIPaddr(String address) {
        int length = address.length();
        char [] chars = new char[length + 6];
        for(int i = 0,j = 0;i < length;i++){
            char c = address.charAt(i);
            if(c == '.'){
                chars[j++] = '[';
                chars[j++] = '.';
                chars[j++] = ']';
            }else{
                chars[j++] = c;
            }
        }
        return new String(chars);
    }
}
