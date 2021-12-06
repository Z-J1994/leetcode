package easy;

public class Solution1816 {
    public String truncateSentence(String s, int k) {
        char [] chars = s.toCharArray();
        for(int i = 0;i < chars.length;i++){
            if(chars[i] == ' '){
                if(--k == 0){
                    return new String(chars,0,i);
                }
            }
        }
        return s;
    }
}
