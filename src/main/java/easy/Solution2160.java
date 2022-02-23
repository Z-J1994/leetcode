package easy;

/**
 * @author zhangjun
 * @version 2022/2/23
 */
public class Solution2160 {
    public int minimumSum(int num) {
        int [] a = {num / 1000,num / 100 % 10,num / 10 % 10,num % 10};
        int max = 0x7fffffff;
        for(int i = 0;i < 4;i++){
            int s = a[i];
            for(int j = 0,k;j < 4;j++){
                if(j == i){
                    continue;
                }
                k = s * 10 + a[j];
                for(int l = 0,t;l < 4;l++){
                    if(l == i || l == j){
                        continue;
                    }
                    t = k + a[l] * 10 + a[6 - l - j - i];
                    if(t < max){
                        max = t;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution2160 s = new Solution2160();
//        System.out.println(s.minimumSum(2932));
        System.out.println(s.minimumSum(2687));
    }
}
