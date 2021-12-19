package easy;

public class Solution997 {
    public int findJudge(int n, int[][] trust) {
        int [] map = new int[n + 1];
        for(int [] i : trust){
            map[i[0]]--;
            map[i[1]]++;
        }
        for(int i = 1;i <= n;i++){
            if(map[i] == n - 1){
                return i;
            }
        }
        return -1;
    }
}
