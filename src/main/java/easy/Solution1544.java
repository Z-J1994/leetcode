package easy;

public class Solution1544 {
    public String makeGood(String s) {
        char [] chars = new char[s.length() + 1];
        int index = 0;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(Math.abs(c - chars[index]) != 32){
                chars[++index] = c;
            }else{
                --index;
            }
        }
        return new String(chars,1,index);
    }
}
