package easy;

/**
 * @author zhangjun
 * @version 2023/1/19
 */
public class Solution2299 {
    public boolean strongPasswordCheckerII(String password) {
        return password.length() >= 8 && valid(password);
    }

    private boolean valid(String password){
        int a = 0,b = 0,c = 0,d = 0;
        char p = ' ';
        for(int i = 0,l = password.length();i < l;i++){
            char ch = password.charAt(i);
            if(p == ch){
                return false;
            }
            p = ch;
            if(ch >= 'a' && ch <= 'z'){
                a++;
            }else if(ch >= 'A' && ch <= 'Z'){
                b++;
            }else if(ch >= '0' && ch <= '9'){
                c++;
            }else{
                d++;
            }
        }
        return a > 0 && b > 0 && c > 0 && d > 0;
    }
}
