package easy;

/**
 * @author zhangjun
 * @since 2022/6/13 12:58
 */
public class Solution1175 {
    public int numPrimeArrangements(int n) {
        boolean [] map = new boolean [101];
        map[1] = true;
        int count = 0;
        for(int i = 2;i <= n;i++){
            if(!map[i]){
                count++;
                for(int j = i + i;j < 101;j+=i){
                    map[j] = true;
                }
            }
        }
        return (int)((factorial(count) * factorial(n - count)) % 1000000007);
    }
    private long factorial(int n){
        long result = 1;
        for(int i = 2;i <= n;i++){
            result = (result * i) % 1000000007;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1175 s = new Solution1175();
        System.out.println(s.numPrimeArrangements(100));
    }
}
