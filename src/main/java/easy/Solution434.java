package easy;

/**
 * @author zhangjun
 * @version 2021/10/7
 */
public class Solution434 {
    public int countSegments(String s) {
        int count = 0;
        char previous = ' ';
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(previous == ' ' && c != ' '){
                count++;
            }
            previous = c;
        }
        return count;
    }
}
