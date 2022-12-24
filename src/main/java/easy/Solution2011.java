package easy;

/**
 * @author zhangjun
 * @version 2022/12/23
 */
public class Solution2011 {
    class Solution {
        public int finalValueAfterOperations(String[] operations) {
            int x = 0;
            for(String s: operations){
                x += select(s);
            }
            return x;
        }
        private int select(String s){
            char c = s.charAt(0);
            if(c != 'X'){
                return get(c);
            }
            return get(s.charAt(2));
        }

        private int get(char c){
            if(c == '-'){
                return -1;
            }else{
                return 1;
            }
        }
    }
}
