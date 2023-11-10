package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhangjun
 * @since 2023/11/10 13:24
 */
public class Solution2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int [][] sortedSpells = new int[spells.length][2];
        for(int i = 0;i < spells.length;i++){
            sortedSpells[i][0] = spells[i];
            sortedSpells[i][1] = i;
        }
        Arrays.sort(potions);
        Arrays.sort(sortedSpells, Comparator.comparingInt(e -> e[0]));
        int [] result = new int[spells.length];
        for(int i = 0,j = potions.length - 1,count = 0;i < spells.length;i++){
            long t = sortedSpells[i][0];
            while(j >= 0 && (t * potions[j]) >= success){
                count++;
                j--;
            }
            result[sortedSpells[i][1]] = count;
        }
        return result;
    }
}
