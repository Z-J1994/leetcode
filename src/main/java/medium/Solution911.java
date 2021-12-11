package medium;

public class Solution911 {
    static class TopVotedCandidate {
        private final int[] answers;
        private final int[] times;

        public TopVotedCandidate(int[] persons, int[] times) {
            this.times = times;
            int[] p = new int[persons.length];
            answers = new int[times.length];
            int max = 0;
            for (int i = 0; i < times.length; i++) {
                if (++p[persons[i]] >= p[max]) {
                    max = persons[i];
                }
                answers[i] = max;
            }
        }

        public int q(int t) {
            int lo = 0, hi = times.length - 1;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;
                if (t > times[mid]) {
                    lo = mid + 1;
                } else if (t < times[mid]) {
                    hi = mid - 1;
                } else {
                    return answers[mid];
                }
            }
            return hi == -1 ? answers[0] : answers[hi];
        }
    }
}
