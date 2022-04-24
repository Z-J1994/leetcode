package easy;

public class Solution914 {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) {
            return false;
        }
        int[] map = new int[10000];
        int length = 0;
        for (int i : deck) {
            if (map[i]++ == 0) {
                length++;
            }
        }
        int[] ns = new int[length];
        int index = 0;
        int max = 0;
        for (int i : deck) {
            if (map[i] != -1) {
                max = Math.max(max, map[i]);
                ns[index++] = map[i];
                map[i] = -1;
            }
        }
        if (check(ns, max)) {
            return true;
        }

        for (int i = 2, n = max / 2; i <= n; i++) {
            if (check(ns, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(int[] data, int target) {
        for (int j = 0; j < data.length; j++) {
            if (data[j] % target != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution914 s = new Solution914();
//        System.out.println(s.hasGroupsSizeX(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2}));
//        System.out.println(s.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(s.hasGroupsSizeX(new int[]{0,0,0,1,1,1,1,1,1,2,2,2,3,3,3}));
    }
}
