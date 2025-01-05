package medium;

import utils.Invoker;

import java.util.Arrays;

public class Solution2241 {

    class ATM {

        private final int [] defaultResult = {-1};

        private final int [] bank = new int [5];

        private final int [] numbers = {20,50,100,200,500};

        public ATM() {

        }

        public void deposit(int[] banknotesCount) {
            for(int i = 0;i < 5;i++){
                bank[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            int [] result = new int[5];
            for(int i = 4;i >= 0 && amount > 0;i--){
                int t;
                if(bank[i] == 0 || (t = amount / numbers[i]) == 0){
                    continue;
                }
                t = Math.min(t,bank[i]);
                result[i] = t;
                amount -= t * numbers[i];
            }
            if(amount > 0){
                return defaultResult;
            }
            for(int i = 0;i < 5;i++){
                bank[i] -= result[i];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Object [] parameters ;

//        parameters = new Object[]{null,new int[][]{{0,0,1,2,1}},600,new int[][]{{0,1,0,1,1}},600,550};
//        System.out.println(Arrays.deepToString(Invoker.invoke(ATM.class,parameters,new Object[parameters.length],
//                new String[]{"ATM","deposit","withdraw","deposit","withdraw","withdraw"})));


        parameters = new Object[]{null,new int[][]{{0,10,0,3,0}},500};
        System.out.println(Arrays.deepToString(Invoker.invoke(ATM.class,parameters,new Object[parameters.length],
                new String[]{"ATM","deposit","withdraw"})));
    }

}
