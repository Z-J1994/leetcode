package easy;

/**
 * @author zhangjun
 * @version 2020/10/01  19:36
 */
public class Solution1160 {
    public int countCharacters(String[] words, String chars) {
        int [] table = new int[26];
        int [] temp = new int[26];
        for(int i = 0;i < chars.length();i++){
            table[chars.charAt(i) - 97]++;
        }
        int count = 0;
        for(int i = 0;i < words.length;i++){
            System.arraycopy(table,0,temp,0,26);
            boolean marked = true;
            for(int j = 0;j < words[i].length();j++){
                if(--temp[words[i].charAt(j) - 97] < 0){
                    marked = false;
                    break;
                }
            }
            if(marked){
                count += words[i].length();
            }
        }
        return count;
    }
}
