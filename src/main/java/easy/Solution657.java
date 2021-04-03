package easy;

/**
 * @author zhangjun
 * @version 2020/09/22  20:49
 */
public class Solution657 {
    public boolean judgeCircle(String moves) {
        int left = 0;
        int right = 0;
        int up = 0;
        int down = 0;
        for(int i = 0;i < moves.length();i++){
            char c = moves.charAt(i);
            switch(c){
                case 'L': left++;break;
                case 'R': right++;break;
                case 'U': up++;break;
                case 'D': down++;break;
            }
        }
        return left == right && up == down;
    }
}
