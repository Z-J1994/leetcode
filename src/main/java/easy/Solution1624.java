package easy;

public class Solution1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int t = -1;
        Integer [] alphabet = new Integer[26];
        for(int i = 0,l = s.length();i < l;i++){
            int c = s.charAt(i) - 97;
            if(alphabet[c] == null){
                alphabet[c] = i;
            }else{
                t = Math.max(i - alphabet[c] - 1,t);
            }
        }
        return t;
    }
}
