package easy;

public class Solution367 {
    public boolean isPerfectSquare(int num) {
        switch(num % 10){
            case 2:
            case 3:
            case 7:
            case 8:
                return false;
        }
        if(num % 3 != 0 && num % 3 != 1){
            return false;
        }
        int lo = 1,hi = num;
        while(lo <= hi){
            int mid = (lo + hi) >>> 1;
            int sum = mid * mid;
            if(sum > num || sum / mid != mid){
                hi = mid - 1;
            }else if(sum < num){
                lo = mid + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
