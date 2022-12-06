package medium;

import utils.Parser;

public class Solution1774 {

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        boolean[] map = new boolean[(target + 1) << 1];
        dfs(toppingCosts, map, 0, 0);
        int min = 0x7fffffff;
        int result = 0;
        for (int baseCost : baseCosts) {
            int t = target - baseCost;
            if (t == 0) {
                return target;
            } else if (t > 0) {
                if (map[t]) {
                    return target;
                }else if(t < min || (t <= min && baseCost < result)){
                    min = t;
                    result = baseCost;
                }
                for (int i = t - 1, j = t + 1; i >= 0 || j < map.length; i--, j++) {
                    if (i >= 0 && map[i]) {
                        if (t - i < min || (t - i <= min && i + baseCost < result)) {
                            min = t - i;
                            result = i + baseCost;
                            break;
                        }
                    } else if (j < map.length&& map[j]) {
                        if (j - t  < min || (j - t <= min && j + baseCost < result)) {
                            min = j - t ;
                            result = j + baseCost;
                            break;
                        }
                    }
                }
            } else {
                if (-t < min) {
                    min = -t;
                    result = baseCost;
                }
            }
        }
        return result;
    }

    private void dfs(int[] toppingCosts, boolean[] map, int index, int sum) {
        if(sum >= map.length){
            return;
        }
        map[sum] = true;
        if (index >= toppingCosts.length) {
            return;
        }
        ++index;
         dfs(toppingCosts, map, index, sum);
        dfs(toppingCosts, map, index, sum + toppingCosts[index - 1]);
        dfs(toppingCosts, map, index, sum + (toppingCosts[index - 1] << 1));
    }

    public static void main(String[] args) {
        Solution1774 s = new Solution1774();
//        System.out.println(s.closestCost(Parser.StringToIntArray("[2,3]"), Parser.StringToIntArray("[4,5,100]"), 18) == 17);
//        System.out.println(s.closestCost(Parser.StringToIntArray("[3,10]"), Parser.StringToIntArray("[2,5]"), 9) == 8);
//        System.out.println(s.closestCost(Parser.StringToIntArray("[1,7]"), Parser.StringToIntArray("[3,4]"), 10) == 10);
//        System.out.println(s.closestCost(Parser.StringToIntArray("[10]"), Parser.StringToIntArray("[1]"), 10) == 10);
//        System.out.println(s.closestCost(Parser.StringToIntArray("[11]"), Parser.StringToIntArray("[1]"), 10) == 11);
//        System.out.println(s.closestCost(Parser.StringToIntArray("[4]"), Parser.StringToIntArray("[9]"), 9) == 13);
//        System.out.println(s.closestCost(Parser.StringToIntArray("[5,77,38,61,97]"), Parser.StringToIntArray("[62,7,100,30,16,84]"), 73) == 72);
//        System.out.println(s.closestCost(Parser.StringToIntArray("[8,4,4,5,8]"), Parser.StringToIntArray("[3,10,9,10,8,10,10,9,3]"), 6) == 5);
//        System.out.println(s.closestCost(Parser.StringToIntArray("[9,10,1]"), Parser.StringToIntArray("[1,8,8,1,1,8]"), 8) == 7);
        System.out.println(s.closestCost(Parser.StringToIntArray("[3738,5646,197,7652]"), Parser.StringToIntArray("[5056]"), 9853) == 10309);
    }

}
