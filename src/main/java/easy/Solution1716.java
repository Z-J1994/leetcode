package main.java.easy;

/**
 * @author zhangjun
 * @version 2021/6/10
 */
public class Solution1716 {
    public int totalMoney(int n) {
        int sum = 21;
        int t = (n / 7);
        sum = sum * t + compute(t) * 7;
        int h = (n % 7);
        return sum + compute(h) + h * t;
    }
    private int compute(int n){
        return  n * (n + 1) / 2;
    }
}
