package easy;

/**
 * description
 *
 * @author zhangjun
 * data 2021/08/17 20:29
 */
public class Solution551 {
    public boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        for(int i = 0,l = s.length();i < l;i++){
            char c = s.charAt(i);
            if(c == 'A'){
                absent++;
                if(absent == 2){
                    return false;
                }
                late = 0;
            }else if(c == 'L'){
                late++;
                if(late == 3){
                    return false;
                }
            }else{
                late = 0;
            }
        }
        return true;
    }
}
