package medium;

/**
 * @author zhangjun
 * @since 2022/5/27 12:34
 */
public class Interview17_11 {
    public int findClosest(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int min = words.length;
        for(int i = 0;i < words.length;i++){
            if(word1.equals(words[i])){
                index1 = i;
                if(index2 != -1){
                    min = Math.min(min,Math.abs(index1 - index2));
                }
            }else if(word2.equals(words[i])){
                index2 = i;
                if(index1 != -1){
                    min = Math.min(min,Math.abs(index1 - index2));
                }
            }
        }
        return min;
    }
}
