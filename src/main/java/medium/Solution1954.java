package medium;

public class Solution1954 {
    public long minimumPerimeter(long neededApples) {
        neededApples = (neededApples + 1) / 2;
        long l = 0,r = 100000;
        while(l < r){
            long mid = (l + r) >>> 1;
            if((mid * (mid + 1) * (mid * 2 + 1)) >= neededApples){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l * 8;
    }
}
