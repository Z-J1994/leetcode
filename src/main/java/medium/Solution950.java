package medium;

import utils.Parser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjun
 * @since 2024/4/10 13:38
 */
public class Solution950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        int [] mirror = new int [deck.length];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < deck.length;i++){
            mirror[i] = deck[i];
            map.put(mirror[i],i);
        }
        Arrays.sort(deck);
        int [] processResult = new int[deck.length];
        for(int index = 0,i = 0,l = 0,pl = deck.length,t = 0;index < deck.length;){
            if((i & 1) == t){
                processResult[index++] = mirror[i];
            }else{
                mirror[l++] = mirror[i];
            }
            if(++i >= pl){
                pl = l;
                t = (i & 1) ^ t;
                i = 0;
                l = 0;
            }
        }

        for(int i = 0;i < deck.length;i++){
            mirror[map.get(processResult[i])] = deck[i];
        }
        return mirror;
    }

    public static void main(String[] args) {
        Solution950 s = new Solution950();
        System.out.println(Arrays.equals(s.deckRevealedIncreasing(Parser.StringToIntArray("[17,13,11,2,3,5,7]")),Parser.StringToIntArray("[2,13,3,11,5,17,7]")));
        System.out.println(Arrays.equals(s.deckRevealedIncreasing(Parser.StringToIntArray("[1,1000]")),Parser.StringToIntArray("[1,1000]")));
    }
}
