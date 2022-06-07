package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangjun
 * @version 2020/10/03  19:47
 */
public class Solution929 {
    public int numUniqueEmails(String[] emails) {
        int result = 0;
        Set<String> set = new HashSet<>();
        for(String s : emails){
            if(set.add(process(s))){
                result++;
            }
        }
        return result;
    }

    private String process(String s){
        int length = s.length();
        char [] chars = new char[length];
        int index = 0;
        int i = 0;
        char c;
        boolean b = true;
        while(i < length && (c = s.charAt(i)) != '@'){
            i++;
            if(c == '.'){
                b = false;
                continue;
            }
            if(c == '+'){
                b = false;
                break;
            }
            chars[index++] = c;
        }
        if(b){
            return s;
        }
        while(i < length && s.charAt(i) != '@'){
            i++;
        }
        while(i < length){
            chars[index++] = s.charAt(i++);
        }
        return new String(chars,0,index);
    }

    public static void main(String[] args) {
        Solution929 s = new Solution929();
        System.out.println(s.numUniqueEmails(new String[]{"abc@def.com", "abcd@ef.com", "ab.c@def.com"}));
    }
}
