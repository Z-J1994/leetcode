package easy;

public class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        char [] chars = new char[word1.length() + word2.length()];
        int index = 0;
        int i = 0;
        int j = 0;
        while(i < word1.length() && j < word2.length()){
            chars[index++] = word1.charAt(i++);
            chars[index++] = word2.charAt(j++);
        }
        while(i < word1.length()){
            chars[index++] = word1.charAt(i++);
        }
        while(j < word2.length()){
            chars[index++] = word2.charAt(j++);
        }
        return new String(chars);
    }
}
