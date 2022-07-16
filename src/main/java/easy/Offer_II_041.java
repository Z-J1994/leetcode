package easy;

public class Offer_II_041 {
    class MovingAverage {
        private int [] data;
        private int index;
        private int sum;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            data = new int[size];
            index = 0;
            sum = 0;
        }

        public double next(int val) {
            int i = index++ % data.length;
            sum = sum - data[i] + val;
            data[i] = val;
            return (double)sum / ((index > data.length) ? data.length : index);
        }
    }
}
