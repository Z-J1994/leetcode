package hard;

/**
 * @author zhangjun
 * @since 2022/9/21 13:28
 */
public class Solution854 {
    private char [] c1;
    private char [] c2;
    private int min;

    public int kSimilarity(String s1, String s2) {
        min = 0x7fffffff;
        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
        dfs(0,0);
        return min;
    }

    private void dfs(int index,int step){
        if(index == c1.length){
            if(step < min){
                min = step;
            }
            return;
        }
        if(c1[index] != c2[index]){
            for(int i = index + 1;i < c1.length;i++){
                if(c1[i] == c2[index]){
                    swap(c1,i,index);
                    dfs(index + 1,step + 1);
                    swap(c1,i,index);
                    if(c2[i] == c1[index]){
                        return;
                    }
                }
            }
        }else{
            dfs(index + 1,step);
        }
    }


    private void swap(char [] c,int i,int j){
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}
