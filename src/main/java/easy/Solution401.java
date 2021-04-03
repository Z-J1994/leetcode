package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjun
 * @version 2020/10/09  19:04
 */
public class Solution401 {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        byte [] zeroH = {0};
        byte [] oneH = {1,2,4,8};
        byte [] twoH = {3,5,6,9,10};
        byte [] threeH = {7,11};

        byte [] zeroM = {0};
        byte [] oneM = {1,2,4,8,16,32};
        byte [] twoM = {3,5,6,9,10,12,17,18,20,24,33,34,36,40,48};
        byte [] threeM = {7,11,13,14,19,21,22,25,26,28,35,37,38,41,42,44,49,50,52,56};
        byte [] fourM = {15,23,27,29,30,39,43,45,46,51,53,54,57,58};
        byte [] fiveM = {31,47,55,59};

        byte [] hour = null;
        byte [] minute = null;
        for(int numH = 0;numH < 4 && numH <= num;numH++){
            StringBuilder s = new StringBuilder();
            int numM = num - numH;
            switch(numH){
                case 0:hour = zeroH;break;
                case 1:hour = oneH;break;
                case 2:hour = twoH;break;
                case 3:hour = threeH;break;
                default:continue;
            }
            switch(numM){
                case 0:minute = zeroM;break;
                case 1:minute = oneM;break;
                case 2:minute = twoM;break;
                case 3:minute = threeM;break;
                case 4:minute = fourM;break;
                case 5:minute = fiveM;break;
                default:continue;
            }
            mix(hour,minute,result);
        }
        return result;
    }
    private void mix(byte[] hour,byte [] minute,List<String>result){
        for(int i = 0;i < hour.length;i++){
            for(int j = 0;j < minute.length;j++){
                StringBuilder s = new StringBuilder();
                s.append(hour[i]).append(":");
                if(minute[j] < 10){
                    s.append("0");
                }
                s.append(minute[j]);
                result.add(s.toString());
            }
        }
    }
}
