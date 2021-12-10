package easy;

public class Solution748 {
    private int [] alphabet = new int [26];
    private int [] chars = new int[7];
    private int cl;
    public String shortestCompletingWord(String licensePlate, String[] words) {
        for(int i = 0;i < licensePlate.length();i++){
            char c = licensePlate.charAt(i);
            if(c >= 'a' && c <= 'z'){
                chars[cl++] = c - 'a';
            }else if(c >= 'A' && c <= 'Z'){
                chars[cl++] = c - 'A';
            }
        }
        String result = "123456789ABCDEFG";
        for(String s : words){
            if(s.length() < result.length() && match(s)){
                result = s;
            }
        }
        return result;
    }
    private boolean match(String s){
        fill();
        for(int i = 0;i < s.length();i++){
            alphabet[s.charAt(i) - 'a']--;
        }
        boolean result = true;
        for(int i = 0;i < cl;i++){
            if(alphabet[chars[i]] > 0){
                result = false;
            }
        }
        erase();
        return result;
    }
    private void fill(){
        for(int i = 0;i < cl;i++){
            alphabet[chars[i]]++;
        }
    }
    private void erase(){
        for(int i = 0;i < cl;i++){
            alphabet[chars[i]] = 0;
        }
    }
}
