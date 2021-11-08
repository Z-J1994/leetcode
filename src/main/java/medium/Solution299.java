package medium;

public class Solution299 {
    public String getHint(String secret, String guess) {
        int [] map = new int[10];
        int a = 0;
        int b = 0;
        for(int i = 0;i < guess.length();i++){
            char c = secret.charAt(i);
            char c1 = guess.charAt(i);
            if(c == c1){
                a++;
            }else{
                if(++map[c - 48] <= 0){
                    b++;
                }
                if(--map[c1 - 48] >= 0){
                    b++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a).append('A').append(b).append('B');
        return sb.toString();
    }
}
