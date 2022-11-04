package medium;

public class Solution754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int left = 0,right = target + 2,mid;
        long r;
        while(left < right){
            mid = (left + right) >>> 1;
            if((r = (mid * (mid + 1L) / 2)) > target){
                right = mid;
            }else if(r < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        r = (left * (left + 1L) / 2) - target;
        if((r & 1) == 0){
            return left;
        }
        return ((r + left + 1) & 1) == 0 ? left + 1 : left + 2;
    }




    public static void main(String[] args) {
        Solution754 s = new Solution754();
        System.out.println(s.reachNumber(3) == 2);
        System.out.println(s.reachNumber(2) == 3);
        System.out.println(s.reachNumber(1000000) == 1415);
        System.out.println(s.reachNumber(1000000000) == 44723);

    }
}
