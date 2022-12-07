package medium;

/**
 * @author zhangjun
 * @version 2022/12/7
 */
public class Solution1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length * 6 || nums2.length > nums1.length * 6){
            return -1;
        }
        int [] map1 = getMap(nums1);
        int [] map2 = getMap(nums2);
        if(map1[0] < map2[0]){
            int [] t = map1;
            map1 = map2;
            map2 = t;
        }
        int count = 0;
        for(int i = 1,j = 1,s = map1[0] - map2[0];s > 0;){
            while(i < 7 && map1[(7 - i)] == 0){
                i++;
            }
            while(j < 7 && map2[j] == 0){
                j++;
            }
            if(i < j){
                count += Math.min(map1[7 - i],(s + 5 - i) / (6 - i));
                s -= (6 - i) * map1[(7 - i)];
                map1[(7 - i)] = 0;
            }else{
                count += Math.min(map2[j],(s + 5 - j) / (6 - j));
                s -= (6 - j) * map2[j];
                map2[j] = 0;
            }
        }
        return count;
    }

    private int [] getMap(int [] data){
        int sum = 0;
        int [] map = new int[7];
        for(int i : data){
            map[i]++;
            sum += i;
        }
        map[0] = sum;
        return map;
    }
}
