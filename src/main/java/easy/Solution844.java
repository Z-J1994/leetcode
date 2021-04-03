package easy;

/**
 * @author zhangjun
 * @version 2020/10/19  16:58
 */
public class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        int indexS = S.length() - 1;
        int indexT = T.length() - 1;

        int stepS = 0;
        int stepT = 0;

        while(indexS >= 0 || indexT >= 0){

            while(indexS >= 0){
                if(S.charAt(indexS) == '#'){
                    stepS++;
                }else if(stepS > 0){
                    stepS--;
                }else{
                    break;
                }
                indexS--;
            }

            while(indexT >= 0){
                if(T.charAt(indexT) == '#'){
                    stepT++;
                }else if(stepT > 0){
                    stepT--;
                }else{
                    break;
                }
                indexT--;
            }

            if(indexT >= 0 && indexS >= 0){
                 if(T.charAt(indexT) != S.charAt(indexS)){
                    return false;
                }
            }else{
                if(indexT >= 0 || indexS >= 0){
                    return false;
                }
            }
            indexS--;
            indexT--;
        }
        return true;
    }
}
