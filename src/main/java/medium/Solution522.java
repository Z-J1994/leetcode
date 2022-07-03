package medium;

/**
 * @author zhangjun
 * @since 2022/6/27 12:22
 */
public class Solution522 {
    public int findLUSlength(String[] strs) {
        boolean [] map = new boolean[strs.length];
        for (int i = 0;i < strs.length;i++) {
            String s = strs[i];
            for(int j = i + 1;j < strs.length;j++){
                if(isSubSequence(s,strs[j])){
                    if(s.length() >= strs[j].length()){
                        map[j] = true;
                    }
                    if(s.length() <= strs[j].length()){
                        map[i] = true;
                    }
                }
            }
        }
        int max = -1;
        for(int i = 0;i < strs.length;i++){
            if(!map[i] && strs[i].length() > max){
                max = strs[i].length();
            }
        }
        return max;
    }

    private boolean isSubSequence(String text,String pattern){
        if(pattern.length() > text.length()){
            String t = pattern;
            pattern = text;
            text = t;
        }
        int i = 0;
        for(int l1 = pattern.length(),l2 = text.length(),j = 0;i < l1 && j < l2;j++){
            if(text.charAt(j) == pattern.charAt(i)){
                i++;
            }
        }
        return i == pattern.length();
    }
}
