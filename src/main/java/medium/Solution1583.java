package medium;

/**
 * @author zhangjun
 * @version 2021/8/14
 */
public class Solution1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int [] mPairs = new int[n];
        for(int [] pair:pairs){
            mPairs[pair[0]] = pair[1];
            mPairs[pair[1]] = pair[0];
        }
        int count = 0;
        for(int i = 0;i < n;i++){
            int index = mPairs[i];
            for(int k : preferences[i]){
                boolean marked = false;
                if(k != index){
                    int index1 = mPairs[k];
                    for(int t : preferences[k]){
                        if(t == index1){
                            break;
                        }
                        if(t == i){
                            count++;
                            marked = true;
                            break;
                        }
                    }
                }else{
                    break;
                }
                if(marked){
                    break;
                }
            }
        }
        return count;
    }

}
