package medium;

/**
 * @author zhangjun
 * @version 2020/11/18  10:59
 */
public class Solution134 {
//    1.
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int length = gas.length;
//        int sumS = 0;
//        int sumC = 0;
//        int t = 0;
//        for(int i = 0;i < length;i++){
//            sumS += gas[i];
//            sumC += cost[i];
//            if(sumS < sumC){
//                t = 1;
//            }
//        }
//        if(sumS < sumC){
//            return -1;
//        }else if(t == 0){
//            return 0;
//        }
//
//        for(int i = 1;i < length;i++){
//            sumS = 0;
//            sumC = 0;
//            for(int j = i,k = 0;k < length;j++,k++){
//                t = j % length;
//                sumS += gas[t];
//                sumC += cost[t];
//                if(sumS < sumC){
//                    break;
//                }
//            }
//            if(sumS >= sumC){
//                return i;
//            }
//        }
//        return -1;
//    }


//    2.
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int length = gas.length;
//        for(int i = 0;i < length;i++){
//            int sumC = 0;
//            int sumS = 0;
//            for(int j = i,k = 0;k < length;j++,k++){
//                int t = j % length;
//                sumS += gas[t];
//                sumC += cost[t];
//                if(sumC > sumS){
//                    i = j;
//                    break;
//                }
//            }
//            if(sumS >= sumC){
//                return i;
//            }
//        }
//        return -1;
//    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int oldSumS = 0;
        int oldSumC = 0;
        for(int i = 0;i < length;i++){
            int sumS = 0;
            int sumC = 0;
            for(int j = i;j < length;j++){
                sumS += gas[j];
                sumC += cost[j];
                if(sumC > sumS){
                    oldSumC += sumC;
                    oldSumS += sumS;
                    i = j;
                    break;
                }
            }
            if(oldSumS + sumS >= oldSumC + sumC){
                return i;
            }
        }
        return -1;
    }
}
