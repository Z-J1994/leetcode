package easy;

public class Solution1796 {
    public int secondHighest(String s) {
        int max = '0' - 1,second = max;
        for(int i = 0,l = s.length();i < l;i++){
            char c = s.charAt(i);
            if(c <= '9'){
                if(c > max){
                    second = max;
                    max = c;
                }else if(c != max && c > second){
                    second = c;
                }
            }
        }
        return second - '0';
    }
}
