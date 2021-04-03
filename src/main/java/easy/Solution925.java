package easy;

/**
 * @author zhangjun
 * @version 2020/10/21  20:36
 */
public class Solution925 {
    public boolean isLongPressedName(String name, String typed) {
        int ln = name.length();
        int tn = typed.length();
        if(tn < ln){
            return false;
        }
        --ln;
        if(name.charAt(0) != typed.charAt(0) || name.charAt(ln) != typed.charAt(tn - 1)){
            return false;
        }

        int t = 0;
        char lastN = ' ';
        for(int i = 0;i < tn;i++){
            char c = typed.charAt(i);
            if(name.charAt(t) == c){
                if(t < ln){
                    lastN = c;
                    t++;
                }
            }else if(c != lastN){
                return false;
            }

        }
        return t == ln;
    }
}
