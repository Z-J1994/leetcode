package hard;

/**
 * @author zhangjun
 * @version 2021/10/11
 */
public class Solution273 {
    private static final int [] index = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,1000,1000000,1000000000};
    private static final String[] values = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety","Hundred","Thousand","Million","Billion"};

    public String numberToWords(int num) {
        return dfs(num,index.length - 1);
    }

    private String dfs(int num,int hi){
        int lo = 0;
        while(lo <= hi){
            int mid = (lo + hi) >>> 1;
            if(index[mid] > num){
                hi = mid - 1;
            }else if(index[mid] < num){
                lo = mid + 1;
            }else{
                if(index[mid] >= 100){
                    return values[1] + " " +values[mid];
                }
                return values[mid];
            }
        }
        StringBuilder sb = new StringBuilder();
        if(index[hi] >= 100){
            sb.append(dfs(num / index[hi],hi)).append(" ");
        }
        sb.append(values[hi]);
        if(num % index[hi] != 0){
            sb.append(" ").append(dfs(num % index[hi],hi));
        }
        return sb.toString();
    }
}
