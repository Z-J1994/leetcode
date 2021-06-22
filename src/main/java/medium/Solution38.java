package medium;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution38 {
    private char [] charset;
    private char [] value;
    private ArrayList<String> list = new ArrayList<>();
    public String[] permutation(String s) {
        charset = s.toCharArray();
        value = new char[s.length()];
        Arrays.sort(charset);
        dfs(0);
        return list.toArray(new String [0]);
    }

    private void dfs(int index){
        if(index == charset.length){
            list.add(new String(value));
            return;
        }
        for(int i = 0;i < charset.length;++i){
            char t = charset[i];
            if(t == 0){
                continue;
            }
            if(i > 0 && charset[i] == charset[i - 1]){
                continue;
            }
            charset[i] = 0;
            value[index] = t;
            dfs(index + 1);
            charset[i] = t;
        }
    }
}
