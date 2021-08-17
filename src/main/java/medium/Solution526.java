package medium;

/**
 * @author zhangjun
 * @version 2021/8/16
 */
public class Solution526 {
    public int countArrangement(int n) {
        return dfs(n,1,new boolean [n + 1]);
    }
    private int dfs(int n,int index,boolean [] visited){
        if(index > n){
            return 1;
        }
        int result = 0;
        for(int i = 1;i <= n;i++){
            if(!visited[i] && (index % i == 0 || i % index == 0)){
                visited[i] = true;
                result += dfs(n,index + 1,visited);
                visited[i] = false;
            }
        }
        return result;
    }
}
