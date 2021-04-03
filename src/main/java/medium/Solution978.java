package medium;

/**
 * @author zhangjun
 * @date 2021/2/8
 */
public class Solution978 {
    public int maxTurbulenceSize(int[] arr) {
        int length = arr.length;
        if(length < 2){
            return 1;
        }
        int max = 0;
        int count = 0;
        boolean previous = (arr[0] > arr[1]);
        for(int i = 1,p = arr[0];i < length;i++){
            int t = arr[i];
            if(p == t){
                max = (count > max) ? count : max;
                while(++i < length){
                    t = arr[i];
                    if(t != p){
                        break;
                    }
                    p = t;
                }
                if(i >= length) {
                    count = 1;
                    break;
                }
                previous = (p > t);
                count = 2;
            }
            boolean current = p > t;
            if(current != previous){
                count++;
            }else{
                max = (count > max) ? count : max;
                count = 2;
            }
            previous = current;
            p = t;
        }
        max = (count > max) ? count : max;
        return max;
    }

    public static void main(String[] args) {
        Solution978 s = new Solution978();
        int [] arr1 = {9,4,2,10,7,8,8,1,9};
        int [] arr2 = {4,8,12,16};
        int [] arr3 = {100};
        int [] arr4 = {1,1,1,1,1,1,1,1};
        System.out.println(s.maxTurbulenceSize(arr1));//5
        System.out.println(s.maxTurbulenceSize(arr2));//2
        System.out.println(s.maxTurbulenceSize(arr3));//1
        System.out.println(s.maxTurbulenceSize(arr4));//1
    }
}
