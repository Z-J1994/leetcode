package hard;

import utils.Parser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int [][] group = new int[startTime.length][3];
        for(int i = 0;i < startTime.length;i++){
            group[i][0] = startTime[i];
            group[i][1] = endTime[i];
            group[i][2] = profit[i];
        }
        Arrays.sort(group,(a, b) ->{
            if(a[1] != b[1]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        Map<Integer,Integer> dp = new HashMap<>();
        dp.put(group[0][1],group[0][2]);
        for(int i = 1;i < startTime.length;i++){
            for(int j = i - 1;j >= 0;j--){
                if(group[j][1] <= group[i][0]){
                    group[i][0] = group[j][1];
                    break;
                }
            }
            dp.put(group[i][1],Math.max(dp.getOrDefault(group[i][0],0) + group[i][2],dp.get(group[i - 1][1])));

        }
        return dp.get(group[group.length - 1][1]);
    }


    public static void main(String[] args) {
        Solution1235 s = new Solution1235();
        System.out.println(s.jobScheduling(Parser.StringToIntArray("[1,2,3,3]"), Parser.StringToIntArray("[3,4,5,6]"), Parser.StringToIntArray("[50,10,40,70]")) == 120);
        System.out.println(s.jobScheduling(Parser.StringToIntArray("[1,1,1]"), Parser.StringToIntArray("[2,3,4]"), Parser.StringToIntArray("[5,6,4]")) == 6);
        System.out.println(s.jobScheduling(Parser.StringToIntArray("[4,2,4,8,2]"), Parser.StringToIntArray("[5,5,5,10,8]"), Parser.StringToIntArray("[1,2,8,10,4]")) == 18);
        System.out.println(s.jobScheduling(Parser.StringToIntArray("[1,2,3,4,6]"), Parser.StringToIntArray("[3,5,10,6,9]"), Parser.StringToIntArray("[20,20,100,70,60]")) == 150);
    }
}
