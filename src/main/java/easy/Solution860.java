package easy;

public class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            switch (bill) {
                case 10:
                    ten++;
                    if (--five < 0) {
                        return false;
                    }
                    break;
                case 20:
                    if (ten > 0) {
                        ten--;
                        if (--five < 0) {
                            return false;
                        }
                    } else if ((five -= 3) < 0) {
                        return false;
                    }
                    break;
                default:
                    five++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution860 s = new Solution860();
        s.lemonadeChange(new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5});
        s.lemonadeChange(new int[]{5, 5, 5, 5, 20, 20, 5, 5, 20, 5});
    }
}
