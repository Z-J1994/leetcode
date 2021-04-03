package medium;

/**
 * @author zhangjun
 * @date 2021/2/23
 */
public class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int length = grumpy.length;

        int income = 0;
        int t = 0;
        for(int i = 0;i < X;i++){
            income += customers[i] * grumpy[i];
            t += customers[i] * (grumpy[i] ^ 1);
        }

        int left = 0;
        int right = X - 1;
        int max = income > 0 ? income : 0;

        while(++right < length){

            income += customers[right] * grumpy[right];
            t += customers[right] * (grumpy[right] ^ 1);
            income -= customers[left] * grumpy[left];

            max = (income > max) ? income : max;
            left++;
        }

        return max + t;
    }

    public static void main(String[] args) {
        Solution1052 s = new Solution1052();
        int [] customers1 = {1,0,1,2,1,1,7,5};
        int [] grumpy1 = {0,1,0,1,0,1,0,1};
        int x1 = 3;

        int [] customers2 = {1};
        int [] grumpy2 = {0};
        int x2 = 1;

        int [] customers3 = {4,10,10};
        int [] grumpy3 = {1,1,0};
        int x3 = 2;

        int [] customers4 = {10,1,7};
        int [] grumpy4 = {0,0,0};
        int x4 = 2;

        int [] customers5 = {7,8,8,6};
        int [] grumpy5 = {0,1,0,1};
        int x5 = 3;

        int [] customers6 = {2,4,1,4,1};
        int [] grumpy6 = {1,0,1,0,1};
        int x6 = 2;


        System.out.println(s.maxSatisfied(customers1,grumpy1,x1) == 16);//16
        System.out.println(s.maxSatisfied(customers2,grumpy2,x2) == 1);//1
        System.out.println(s.maxSatisfied(customers3,grumpy3,x3) == 24);//24
        System.out.println(s.maxSatisfied(customers4,grumpy4,x4) == 18);//18
        System.out.println(s.maxSatisfied(customers5,grumpy5,x5) == 29);//29
        System.out.println(s.maxSatisfied(customers6,grumpy6,x6) == 10);//10
    }
}
