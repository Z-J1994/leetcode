package easy;

import java.util.Arrays;

public class Solution937 {
    public String[] reorderLogFiles(String[] logs) {
        int limit = logs.length - 1;
        char c;
        for (int l = limit; l >= 0; l--) {
            c = logs[l].charAt(logs[l].length() - 1);
            if (c >= '0' && c <= '9') {
                String t = logs[l];
                logs[l] = logs[limit];
                logs[limit--] = t;
            }
        }
        quickSort(logs, 0, limit);
        return logs;
    }

    private void quickSort(String [] data,int lo,int hi){
        if(lo < hi){
            int p = exchange(data,lo,hi);
            quickSort(data,lo,p - 1);
            quickSort(data,p + 1,hi);
        }
    }

    private int exchange(String [] data,int lo,int hi){
        int mid = (lo + hi) >>> 1;
        String minValue = data[lo];
        String midValue = data[mid];
        String maxValue = data[hi];

        if(compare(minValue,midValue) > 0){
            String t = midValue;
            midValue = minValue;
            minValue = t;
        }

        if(compare(minValue,maxValue) > 0){
            String t = maxValue;
            maxValue = minValue;
            minValue = t;
        }

        if(compare(midValue,maxValue) > 0){
            String t = maxValue;
            maxValue = midValue;
            midValue = t;
        }
        data[lo] = midValue;
        data[mid] = minValue;
        data[hi] = maxValue;
        return partition(data,lo,hi);
    }

    private int partition(String[] data, int lo, int hi) {
        int i = lo;
        String pivot = data[lo];
        while (true) {
            while (compare(pivot, data[++i]) > 0) ;
            while (compare(pivot, data[--hi]) < 0) ;
            if (i >= hi) {
                break;
            }
            String s = data[i];
            data[i] = data[hi];
            data[hi] = s;
        }
        data[lo] = data[hi];
        data[hi] = pivot;
        return hi;
    }

    private int compare(String s1, String s2) {
        int head = 0;
        int f1 = 0, f2 = 0;
        int l1 = s1.length();
        int l2 = s2.length();
        while (f1 < l1 && f2 < l2) {
            head = s1.charAt(f1) - s2.charAt(f2);
            if (head != 0 || s1.charAt(f1) == ' ') {
                break;
            }
            f1++;
            f2++;
        }
        while (s1.charAt(f1) != ' ') {
            f1++;
        }
        while (s2.charAt(f2) != ' ') {
            f2++;
        }
        int body;
        while (f1 < l1 && f2 < l2) {
            body = s1.charAt(f1++) - s2.charAt(f2++);
            if (body != 0) {
                return body;
            }
        }
        if (f1 < l1) {
            return 1;
        }
        if (f2 < l2) {
            return -1;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution937 s = new Solution937();
        System.out.println(Arrays.toString(s.reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
    }
}
