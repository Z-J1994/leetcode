package easy;

/**
 * @author zhangjun
 * @version 2020/09/19  14:43
 */
public class LCP17 {
    public int calculate(String s) {
        int x = 1;
        int y = 0;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            switch(c){
                case 'A':x = 2 * x + y;break;
                case 'B':y = 2 * y + x;break;
            }
        }
        return x + y;
    }
}
