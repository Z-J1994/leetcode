package easy;

public class Solution520 {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1){
            return true;
        }
        if(word.charAt(0) >= 'a'){
            if((word.charAt(1) < 'a')){
                return false;
            }
        }
        for(int i = 2;i < word.length();i++){
            if((word.charAt(i) >= 'a' && word.charAt(i - 1) < 'a') || (word.charAt(i) < 'a' && word.charAt(i - 1) >= 'a')){
                return false;
            }
        }
        return true;
    }
}
