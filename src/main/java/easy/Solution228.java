package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int length = nums.length;
        if(length == 0){
            return result;
        }

        int pre = nums[0];
        int start = pre;
        for(int i = 1;i < length;i++){
            int c = nums[i];
            if(c - pre != 1){
                StringBuilder sb = new StringBuilder();
                if(start == pre){
                    sb.append(start);
                }else{
                    sb.append(start).append("->").append(pre);
                }
                result.add(sb.toString());
                start = c;
            }
            pre = c;
        }
        StringBuilder sb = new StringBuilder();
        if(start == nums[length - 1]){
            sb.append(start);
        }else{
            sb.append(start).append("->").append(pre);
        }
        result.add(sb.toString());
        return result;
    }
}
