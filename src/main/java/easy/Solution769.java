package easy;

/**
 * @author zhangjun
 * @version 2022/3/24
 */
public class Solution769 {
    public boolean rotateString(String s, String goal) {
//        return s.length() == goal.length() && (s + s).contains(goal);
        if(s.length() != goal.length()){
            return false;
        }
        int length = s.length();
        char [] ss = new char[length << 1];
        for(int i = 0,j = s.length();i < length;i++,j++){
            char c = s.charAt(i);
            ss[i] = c;
            ss[j] = c;
        }
        for(int i = 0,j;i <= length;i++){
            for(j = 0;j < length;j++){
                if(ss[i + j] != goal.charAt(j)){
                    break;
                }
            }
            if(j == length){
                return true;
            }
        }
        return false;
    }
}
