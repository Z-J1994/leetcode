package easy;

/**
 * @author zhangjun
 * @since 2023/11/7 12:47
 */
public class Solution2586 {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        int [] map = new int[26];
        map[0] = 1;
        map['e' - 'a'] = 1;
        map['i' - 'a'] = 1;
        map['o' - 'a'] = 1;
        map['u' - 'a'] = 1;
        while(left <= right){
            String world = words[left++];
            count += map[world.charAt(0) - 'a'] & map[world.charAt(world.length() - 1) - 'a'];
        }
        return count;
    }
}
