package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author zhangjun
 * data 2021/08/28 12:59
 */
public class Solution22 {
    private List<String> result;
    private int size;
    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        size = n * 2;
        dfs(new char[size],0,0,0);
        return result;
    }
    private void dfs(char [] chars,int left,int right,int index){
        if(index == size){
            if(left == right){
                result.add(new String(chars));
            }
            return;
        }
        if(left == right){
            chars[index] = '(';
            dfs(chars,left + 1,right,index + 1);
        }else{
            chars[index] = '(';
            dfs(chars,left + 1,right,index + 1);

            chars[index] = ')';
            dfs(chars,left,right + 1,index + 1);
        }
    }
}
