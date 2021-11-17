package medium;

public class Solution318 {
    public int maxProduct(String[] words) {
        int result = 0;
        for(int i = 0;i < words.length;i++){
            boolean [] marked = new boolean[26];
            populate(marked,words[i]);
            for(int j = i + 1;j < words.length;j++){
                if(check(marked,words[j]) && words[j].length() * words[i].length() > result){
                    result = words[j].length() * words[i].length();
                }
            }
        }
        return result;
    }

    private boolean check(boolean [] marked,String s){
        for(int i = 0;i < s.length();i++){
            if(marked[s.charAt(i) - 97]){
                return false;
            }
        }
        return true;
    }

    private void populate(boolean [] marked,String s){
        for(int i = 0;i < s.length();i++){
            marked[s.charAt(i) - 97] = true;
        }
    }
}
