package medium;

public class Solution2048 {
    public int nextBeautifulNumber(int n) {
        while(!isBeautifulNumber(++n));
        return n;
    }


    private boolean isBeautifulNumber(int x){
        int [] map = new int[10];
        while(x > 0){
            map[x % 10]++;
            x /= 10;
        }
        for(int i = 0;i < 10;i++){
            if(map[i] != 0 && map[i] != i){
                return false;
            }
        }
        return true;
    }
}
