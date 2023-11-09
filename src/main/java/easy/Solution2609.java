package easy;

/**
 * @author zhangjun
 * @since 2023/11/8 12:54
 */
public class Solution2609 {

    public int findTheLongestBalancedSubstring(String s) {
        int max = 0;
        char p = ' ';
        for(int i = 0,z = 0,o = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(c == '0'){
                if(p != '0'){
                    z = 1;
                }else{
                    z++;
                }
            }else {
                if(p != '1'){
                    o = 1;
                }else{
                    o++;
                }
                max = Math.max(max,Math.min(z,o) << 1);
            }
            p = c;
        }
        return max;
    }

}
