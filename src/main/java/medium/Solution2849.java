package medium;

public class Solution2849 {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        return !(sx == fx && sy == fy && t == 1) && (t >= Math.max(Math.abs(sx - fx),Math.abs(sy - fy)));
    }
}
