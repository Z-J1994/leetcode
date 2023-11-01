package easy;

/**
 * @author zhangjun
 * @version 2023/1/3
 */
public class Solution2042 {
    public boolean areNumbersAscending(String s) {
        int p = -1,c = 0;
        char t;
        for(int i = 0,l = s.length();i < l && p < c;i++){
            while(i < l && ((t = s.charAt(i)) > '9' || t == ' ')){
                i++;
            }
            p = c;
            c = 0;
            while(i < l && ((t = s.charAt(i)) >= '0' && t <= '9')){
                c = c * 10 + t - '0';
                i++;
            }
        }
        return c == 0 || p < c;
    }

    public static void main(String[] args) {
        Solution2042 s = new Solution2042();
        System.out.println(s.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }
}
