package easy;

import java.util.List;

public class Solution1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        int key = 0;
        if("color".equals(ruleKey)){
            key = 1;
        }else if("name".equals(ruleKey)){
            key = 2;
        }
        for(List<String> item : items){
            if(ruleValue.equals(item.get(key))){
                count++;
            }
        }
        return count;
    }
}
