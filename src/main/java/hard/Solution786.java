package hard;

public class Solution786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        k -= 1;
        double[][] data = new double[arr.length * (arr.length - 1) / 2][3];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                data[index][0] = (arr[i] * 1.0) / arr[j];
                data[index][1] = arr[i];
                data[index++][2] = arr[j];
            }
        }
        select(data,0,data.length - 1,k);
        return new int[]{(int)data[k][1], (int)data[k][2]};
    }

    private void select(double[][] data, int lo, int hi, int k) {
        if (lo < hi) {
            int index = random(data, lo, hi);
            if (index < k) {
                select(data, index + 1, hi, k);
            } else if (index > k) {
                select(data, lo, index - 1, k);
            }
        }
    }

    private int random(double[][] data, int lo, int hi) {
        int mid = (lo + hi) >>> 1;
        double[] minValue = data[lo];
        double[] midValue = data[mid];
        double[] maxValue = data[hi];

        if (maxValue[0] < midValue[0]) {
            double[] t = maxValue;
            maxValue = midValue;
            midValue = t;
        }

        if (maxValue[0] < minValue[0]) {
            double[] t = maxValue;
            maxValue = minValue;
            minValue = t;
        }
        if (midValue[0] < minValue[0]) {
            double[] t = midValue;
            midValue = minValue;
            minValue = t;
        }
        data[lo] = midValue;
        data[mid] = minValue;
        data[hi] = maxValue;
        return partition(data, lo, hi);
    }

    private int partition(double[][] data, int lo, int hi) {
        double[] v = data[lo];
        int i = lo;
        int j = hi;
        while (true) {
            while (data[++i][0] < v[0]) ;
            while (data[--j][0] > v[0]) ;
            if (i >= j) {
                break;
            }
            double[] t = data[i];
            data[i] = data[j];
            data[j] = t;
        }

        data[lo] = data[j];
        data[j] = v;
        return j;
    }
}
