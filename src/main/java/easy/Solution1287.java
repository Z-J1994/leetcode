package easy;

/**
 * @author zhangjun
 * @since 2022/6/29 12:55
 */
public class Solution1287 {
    public int findSpecialInteger(int[] arr) {
        int p = -1;
        int count = 0;
        int quarter = arr.length>>> 2;
        for(int t : arr){
            if(p == t){
                if(++count > quarter){
                    return t;
                }
            }else{
                p = t;
                count = 1;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        Solution1287 s = new Solution1287();
        s.findSpecialInteger(new int[]{1,1,2,2,3,3,3,3});
    }
}
