package easy;

public class Solution953 {
    public boolean isAlienSorted(String[] words, String order) {
        int [] alphabet = new int [26];
        for(int i = 0,l = order.length();i < l;i++){
            alphabet[order.charAt(i) - 97] = i;
        }
        for(int i = 1;i < words.length;i++){
            if(!le(alphabet,words[i - 1],words[i])){
                return false;
            }
        }
        return true;
    }

    private boolean le(int [] alphabet,String s1,String s2){
        for(int i = 0,t,l = Math.min(s1.length(),s2.length());i < l;i++){
            if((t = alphabet[s1.charAt(i) - 97] - alphabet[s2.charAt(i) - 97]) > 0){
                return false;
            }else if(t < 0){
                return true;
            }
        }
        return s1.length() <= s2.length();
    }

    public static void main(String[] args) {
        Solution953 s = new Solution953();
    }
}
