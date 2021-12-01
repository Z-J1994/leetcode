package easy;

public class Solution1446 {
    public int maxPower(String s) {
        int max = 1;
        char c = s.charAt(0);
        int count = 1;
        for(int i = 1;i < s.length();i++){
            if(c == s.charAt(i)){
                count++;
            }else {
                if(count > max){
                    max = count;
                }
                count = 1;
                c = s.charAt(i);
            }
        }
        if(count > max){
            max = count;
        }
        return max;
    }
}
