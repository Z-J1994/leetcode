package easy;

public class Solution575 {
    public int distributeCandies(int[] candyType) {
        byte [] map = new byte[200001];
        int typeCount = 0;
        for(int i = 0;i < candyType.length;i++){
            typeCount += (map[candyType[i] + 100000] ^ 1);
            map[candyType[i] + 100000] = 1;
        }
        int half = candyType.length / 2;
        return Math.min(half, typeCount);
    }
}
