package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        for(int i = 1;i <= 9 && i <= n;i++){
            result.add(i);
            dfs(result,i,n);
        }
        return result;
    }

    private void dfs(List<Integer> list,int from,int n){
        from *= 10;
        for(int i = 0;i <= 9 && from + i <= n;i++){
            list.add(from + i);
            dfs(list,from + i,n);
        }
    }
}
