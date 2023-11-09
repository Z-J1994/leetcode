package medium;

public class Solution318 {
    public int maxProduct(String[] words) {
        int [] map = new int [words.length];
        for(int i = 0;i < words.length;i++){
            String word = words[i];
            int t = 0;
            for(int j = 0;j < word.length();j++){
                t |= 1 << (word.charAt(j) - 'a');
            }
            map[i] = t;
        }
        int max = 0;
        for(int i = 0;i < words.length;i++){
            for(int j = i + 1;j < words.length;j++){
                if((map[i] & map[j]) == 0){
                    max = Math.max(words[j].length() * words[i].length(),max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution318 s = new Solution318();
        System.out.println(s.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
    }
}
