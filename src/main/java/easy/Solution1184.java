package easy;

/**
 * @author zhangjun
 * @since 2022/6/17 12:53
 */
public class Solution1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int min = 0x7fffffff;
        int d = 0;
        for(int i = start;i != destination; i = (i + 1) % distance.length){
            d += distance[i];
        }
        if(min > d){
            min = d;
        }
        d = 0;
        for(int i = destination;i != start; i = (i + 1) % distance.length){
            d += distance[i];
        }
        return Math.min(min, d);
    }
}
