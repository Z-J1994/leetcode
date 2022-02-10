package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2022/2/10
 */
public class Solution1447 {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        for(int i = 2;i <= n;i++){
            for(int j = 1;j < i;j++){
                if(gcd(i,j) == 1){
                    result.add(j + "/" + i);
                }
            }
        }
        return result;
    }

    private int gcd(int p,int q){
        int r = p % q;
        while(r != 0){
            p = q;
            q = r;
            r = p % q;
        }
        return q;
    }
}
