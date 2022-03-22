package medium;

/**
 * @author zhangjun
 * @version 2022/3/22
 */
public class Solution2038 {
    public boolean winnerOfGame(String colors) {
        int operationCountA = 0;
        int operationCountB = 0;
        int count = 0;
        char p = 'c';
        char c = 'c';
        for(int i = 0,l = colors.length();i < l;i++){
            c = colors.charAt(i);
            if(p == c){
                count++;
            }else{
                if(count > 2){
                    if(p == 'A'){
                        operationCountA += count - 2;
                    }else {
                        operationCountB += count - 2;
                    }
                }
                p = c;
                count = 1;
            }
        }
        if(count > 2){
            if(c == 'A'){
                operationCountA += count - 2;
            }else {
                operationCountB += count - 2;
            }
        }
        return operationCountA > operationCountB;
    }
}
