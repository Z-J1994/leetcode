package hard;

public class Solution135 {

    public int candy(int[] ratings) {
        int length = ratings.length;
        if(length < 2){
            return length;
        }
        int sum = 1;
        int increase = 1;
        int decrease = 1;

        for(int i = 1;i < length;i++){
            int a = ratings[i];
            int b = ratings[i - 1];
            if(a > b){
                if(decrease != 0){
                    increase = 1;
                }
                decrease = 0;
                ++increase;
                sum += increase;
            }else if(a < b){
                ++decrease;
                if(decrease == increase){
                    ++decrease;
                }
                sum += decrease;
            }else{
                increase = 1;
                decrease = 0;
                ++sum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution135 s = new Solution135();
        int [] ratings1 = {1,0,2};//5
        int [] ratings2 = {1,2,2};//4
        int [] ratings3 = {1,1,1,1,1,1,1,1,1,1};//10
        int [] ratings4 = {1,2,3,4,5,4,3,2,1};//25
        int [] ratings5 = {0,1,2,3,2,1,0,-1};//21
        int [] ratings6 = {0,1,2,2,2,1,0,-1};//17
        int [] ratings7 = {0,1,2,3,4,5,6,7,8,9};//55
        int [] ratings8 = {9,8,7,6,5,4,3,2,1,0};//55
        int [] ratings9 = {0,1,2,3,4,4,3,2,1,0};//30
        int [] ratings10 = {0,1,4,3,2,5,6,10,9,8};//21d
        int [] ratings11 = {0};//1
        int [] ratings12 = {0,1};//3
        int [] ratings13 = {1,1};//2
        System.out.println(s.candy(ratings1) == 5);
        System.out.println(s.candy(ratings2) == 4);
        System.out.println(s.candy(ratings3) == 10);
        System.out.println(s.candy(ratings4) == 25);
        System.out.println(s.candy(ratings5) == 21);
        System.out.println(s.candy(ratings6) == 17);
        System.out.println(s.candy(ratings7) == 55);
        System.out.println(s.candy(ratings8) == 55);
        System.out.println(s.candy(ratings9) == 30);
        System.out.println(s.candy(ratings10) == 21);
        System.out.println(s.candy(ratings11) == 1);
        System.out.println(s.candy(ratings12) == 3);
        System.out.println(s.candy(ratings13) == 2);
    }
}
