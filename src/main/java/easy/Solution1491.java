package easy;

/**
 * @author zhangjun
 * @version 2020/10/10  19:42
 */
public class Solution1491 {
    public double average(int[] salary) {
        int max = salary[0];
        int min = salary[0];
        int sum = 0;
        for(int i = 0;i < salary.length;i++){
            int t = salary[i];
            sum += t;
            if(max < t){
                max = t;
            }else if(min > t){
                min = t;
            }
        }
        return (double)(sum - (min + max)) / (salary.length - 2);
    }
}
