package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution784 {
    public List<String> letterCasePermutation(String s) {
        List<String>list = new ArrayList<>();
        dfs(list,s.toCharArray(),0);
        return list;
    }

    private void dfs(List<String> list,char [] chars,int index){
        if(index == chars.length){
            list.add(new String(chars));
            return;
        }
        dfs(list,chars,index + 1);
        if(chars[index] >= 'A'){
            if(chars[index] < 'a'){
                chars[index] += 32;
                dfs(list,chars,index + 1);
                chars[index] -= 32;
            }else{
                chars[index] -= 32;
                dfs(list,chars,index + 1);
                chars[index] += 32;
            }
        }
    }
}
