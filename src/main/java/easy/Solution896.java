package easy;

/**
 * @author zhangjun
 * @date 2021/2/28
 */
public class Solution896 {
    public boolean isMonotonic(int[] A) {
        int length = A.length;
        boolean marked = true;
        if(A[0] < A[length - 1]){
            for(int i = 1,s = A[0],t;i < length;i++){
                t = A[i];
                marked = marked && (s <= t);
                s = t;
            }
        }else{
            for(int i = 1,s = A[0],t;i < length;i++){
                t = A[i];
                marked = marked && (s >= t);
                s = t;
            }
        }
        return marked;
    }

    public static void main(String[] args) {
        Solution896 s = new Solution896();

        int [] A1 = {1,2,2,3};
        int [] A2 = {6,5,4,4};
        int [] A3 = {1,3,2};
        int [] A4 = {1,2,4,5};
        int [] A5 = {1,1,1};
        int [] A6= {3,3,2,2};

        System.out.println(s.isMonotonic(A1));
        System.out.println(s.isMonotonic(A2));
        System.out.println(s.isMonotonic(A3));//false;
        System.out.println(s.isMonotonic(A4));
        System.out.println(s.isMonotonic(A5));
        System.out.println(s.isMonotonic(A6));
    }
}
