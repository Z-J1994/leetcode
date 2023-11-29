package medium;

import utils.Invoker;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangjun
 * @since 2023/11/29 12:37
 */
public class Solution2336 {
    class SmallestInfiniteSet {

        private int[] heap;

        private int size;

        private int left = 1;

        private Set<Integer> set;

        public SmallestInfiniteSet() {
            heap = new int[16];
            set = new HashSet<>();
        }

        public int popSmallest() {
            return pop();
        }

        public void addBack(int num) {
            add(num);
        }


        private void swim(int i) {
            int value = heap[i];
            for (int parent = (i - 1) >>> 1; i > 0 && value < heap[parent]; i = parent, parent = (i - 1) >>> 1) {
                heap[i] = heap[parent];
            }
            heap[i] = value;
        }

        private void sink(int i) {
            int value = heap[i];
            for (int child = (i << 1) + 1; child < size; i = child, child = (i << 1) + 1) {
                if (child + 1 < size && heap[child + 1] < heap[child]) {
                    child++;
                }
                if (value <= heap[child]) {
                    break;
                }
                heap[i] = heap[child];
            }
            heap[i] = value;
        }

        private int pop() {
            if (size == 0) {
                return left++;
            }
            int min = heap[0];
            heap[0] = heap[--size];
            sink(0);
            set.remove(min);
            return min;
        }


        private void add(int num) {
            if (num >= left) {
                return;
            }
            if (!set.add(num)) {
                return;
            }
            if (size == heap.length) {
                heap = Arrays.copyOf(heap, heap.length << 1);
            }
            heap[size] = num;
            swim(size++);
        }
    }

    public static void main(String[] args) {
        Solution2336 s = new Solution2336();
        Object[] parameters;
        Integer[] result;

//        parameters = new Integer[]{null, null, 529, null, 779, 732, null, null, null, 494, 907, 641, 226, 194, 182, 532, 477, null, null, 902, null, 564, 61, 301, null, null, null, 924, null, null, null, 591, 988, 653, 607, null, 718, 110, 350, null, 22, 495, 424, null, 328, null, 803, 540, 249, null, null, null, null, 378, 329, null, null, 57, null, 139, 135, null, 479, 869, 424, null, 533, null, null, null, null, 704, 542, null, 602, null, null, null, 235, 851, null, null, 273, null, null, 346, null, 453, 726, null, 609, null, 263, null, null, 507, 38, null, 189, null, 756, null, 652, 736, null, 264, 642, null, null, null, null, 964, 278, 220, null, 695, 76, null, 197, 571, null, 185, null, null, null, null, 293, null, null, null, 890, null, null, 98, null, null, null, 302, 770, 364, 173, 363, 662, null, null, 117, 177, 104, 43, 697, 156, 174, 649, 259, 40, 140, 126, 530, 886, 531, null, 451, null, null, null, null, 452, 542, null, 941, 979, null, null, null, 992, null, 745, null, null, 960, null, 795, null, null, 118, 471, null, null, 226, 458, null, 302, null, null, 264, 114, null, 374, null, null, null, 36, null, 288, 712, null, 629, 449, null, 669, 450, null, null, 184, null, 144, 313, 940, null, null, 645, 249, 591, 31, 43, 941, 898, null};
//        result = new Integer[parameters.length];
//        System.out.println(Arrays.toString(Invoker.invoke(SmallestInfiniteSet.class, parameters,result,new String[]{"SmallestInfiniteSet","popSmallest","addBack","popSmallest","addBack","addBack","popSmallest","popSmallest","popSmallest","addBack","addBack","addBack","addBack","addBack","addBack","addBack","addBack","popSmallest","popSmallest","addBack","popSmallest","addBack","addBack","addBack","popSmallest","popSmallest","popSmallest","addBack","popSmallest","popSmallest","popSmallest","addBack","addBack","addBack","addBack","popSmallest","addBack","addBack","addBack","popSmallest","addBack","addBack","addBack","popSmallest","addBack","popSmallest","addBack","addBack","addBack","popSmallest","popSmallest","popSmallest","popSmallest","addBack","addBack","popSmallest","popSmallest","addBack","popSmallest","addBack","addBack","popSmallest","addBack","addBack","addBack","popSmallest","addBack","popSmallest","popSmallest","popSmallest","popSmallest","addBack","addBack","popSmallest","addBack","popSmallest","popSmallest","popSmallest","addBack","addBack","popSmallest","popSmallest","addBack","popSmallest","popSmallest","addBack","popSmallest","addBack","addBack","popSmallest","addBack","popSmallest","addBack","popSmallest","popSmallest","addBack","addBack","popSmallest","addBack","popSmallest","addBack","popSmallest","addBack","addBack","popSmallest","addBack","addBack","popSmallest","popSmallest","popSmallest","popSmallest","addBack","addBack","addBack","popSmallest","addBack","addBack","popSmallest","addBack","addBack","popSmallest","addBack","popSmallest","popSmallest","popSmallest","popSmallest","addBack","popSmallest","popSmallest","popSmallest","addBack","popSmallest","popSmallest","addBack","popSmallest","popSmallest","popSmallest","addBack","addBack","addBack","addBack","addBack","addBack","popSmallest","popSmallest","addBack","addBack","addBack","addBack","addBack","addBack","addBack","addBack","addBack","addBack","addBack","addBack","addBack","addBack","addBack","popSmallest","addBack","popSmallest","popSmallest","popSmallest","popSmallest","addBack","addBack","popSmallest","addBack","addBack","popSmallest","popSmallest","popSmallest","addBack","popSmallest","addBack","popSmallest","popSmallest","addBack","popSmallest","addBack","popSmallest","popSmallest","addBack","addBack","popSmallest","popSmallest","addBack","addBack","popSmallest","addBack","popSmallest","popSmallest","addBack","addBack","popSmallest","addBack","popSmallest","popSmallest","popSmallest","addBack","popSmallest","addBack","addBack","popSmallest","addBack","addBack","popSmallest","addBack","addBack","popSmallest","popSmallest","addBack","popSmallest","addBack","addBack","addBack","popSmallest","popSmallest","addBack","addBack","addBack","addBack","addBack","addBack","addBack","popSmallest"})));


        parameters = new Integer[]{null,745,142,183,null,175,855,null,null,4,327,null,null,979,942,10,null,null,808,37,206,null,null,null,null,null,636,169,318,230,null,null,218,null,158,754,310,null,400,416,null,484,66,859,null,397,760,null,null,null,null,247,443,523,116,525,888,null,646,null,227,null,null,760,867,null,494,444,null,640,null,null,null,null,175,null,741,null,780,null,132,null,459,null,null,467,332,null,999,null,183,null,661,null,62,687,null,468,null,395,154,null,null,409,null,null,null,null,null,null,349,71,166,178,null,466,null,989,null,697,null,300,141,278,null,696,null,null,null,null,null,null,null,294,660,729,279,null,null,162,60,null,30,793,300,null,422,591,null,740,277,558,null,null,676,null,110,null,null,null,806,421,497,null,991,null,null,null,93,null,null,147,292,null,304,108,245,586,326,989,763,null,712,null,680,39,null,303,995,755,330,null,928,635,492,null,907,null,null,null,null,null,151,null,null,null,545,155,null,null,null,null,null,965,null,null,null,422,949,null,null,831,445,null,null,721,983,885,658,807,null,215,null,null,null,495,845,764,null,132,null,423,77,null,null,449,null,524,null,null,null,null,null,null,133,null,881,692,null,931,null,null,471,276,255,359,null,510,null,null,926,null,829,null,null,null,null,430,null,null,928,934,551,null,460,495,null,100,null,null,null,null,384,235,null,480,null,494,168,748,442,null,null,null,449,833,65,null,990,null,null,null,878,null,null,542,657,607,null,null,null,null,641,null,null,null,301,null,656,205,384,null,757,960,null,null,null,905,null,null,2,842,663,null,null,419,910,470,null,null,null,null,null,null,null,null,487,null,null,null,634,713,null,null,308,760,538,null,null,null,null,339,159,961,960,54,556,null,null,916,null,702,468,null,null,null,null,112,null,518,380,250,null,null,null,403,null,294,null,null,657,null,942,821,227,657,745,776,907,null,null,577,null,null,997,607,null,484,243,275,547,null,516,833,null,null,734,null,359,540,null,936,842,426,293,null,187,417,898,240,233,924,null,null,89,462,97,null,null,694,null,null,163,null,null,198,785,234,968,658,811,null,454,104,null,496,720,null,994,null,null,389,152,876,681,453,null,null,null,516,null,null,679,null,null,201,null,null,8,478,460,null,734,901,485,null,null,463,null,348,null,null,883,497,77,null,680,636,343,195,978,872,453,568,null,null,76,null,156,210,539,301,114,611,51,471,null,null,137,null,null,169,null,null,772,null,null,166,899,null,null,52,889,null,null,588,288,null,447,null,704,null,933,null,467,55,526,null,null,223,null,717,462,null,219,331,764,544,766};
        result = new Integer[parameters.length];
        System.out.println(Arrays.toString(Invoker.invoke(SmallestInfiniteSet.class, parameters,result,new String[]{"SmallestInfiniteSet","addBack","addBack","addBack","popSmallest","addBack","addBack","popSmallest","popSmallest","addBack","addBack","popSmallest","popSmallest","addBack","addBack","addBack","popSmallest","popSmallest","addBack","addBack","addBack","popSmallest","popSmallest","popSmallest","popSmallest","popSmallest","addBack","addBack","addBack","addBack","popSmallest","popSmallest","addBack","popSmallest","addBack","addBack","addBack","popSmallest","addBack","addBack","popSmallest","addBack","addBack","addBack","popSmallest","addBack","addBack","popSmallest","popSmallest","popSmallest","popSmallest","addBack","addBack","addBack","addBack","addBack","addBack","popSmallest","addBack","popSmallest","addBack","popSmallest","popSmallest","addBack","addBack","popSmallest","addBack","addBack","popSmallest","addBack","popSmallest","popSmallest","popSmallest","popSmallest","addBack","popSmallest","addBack","popSmallest","addBack","popSmallest","addBack","popSmallest","addBack","popSmallest","popSmallest","addBack","addBack","popSmallest","addBack","popSmallest","addBack","popSmallest","addBack","popSmallest","addBack","addBack","popSmallest","addBack","popSmallest","addBack","addBack","popSmallest","popSmallest","addBack","popSmallest","popSmallest","popSmallest","popSmallest","popSmallest","popSmallest","addBack","addBack","addBack","addBack","popSmallest","addBack","popSmallest","addBack","popSmallest","addBack","popSmallest","addBack","addBack","addBack","popSmallest","addBack","popSmallest","popSmallest","popSmallest","popSmallest","popSmallest","popSmallest","popSmallest","addBack","addBack","addBack","addBack","popSmallest","popSmallest","addBack","addBack","popSmallest","addBack","addBack","addBack","popSmallest","addBack","addBack","popSmallest","addBack","addBack","addBack","popSmallest","popSmallest","addBack","popSmallest","addBack","popSmallest","popSmallest","popSmallest","addBack","addBack","addBack","popSmallest","addBack","popSmallest","popSmallest","popSmallest","addBack","popSmallest","popSmallest","addBack","addBack","popSmallest","addBack","addBack","addBack","addBack","addBack","addBack","addBack","popSmallest","addBack","popSmallest","addBack","addBack","popSmallest","addBack","addBack","addBack","addBack","popSmallest","addBack","addBack","addBack","popSmallest","addBack","popSmallest","popSmallest","popSmallest","popSmallest","popSmallest","addBack","popSmallest","popSmallest","popSmallest","addBack","addBack","popSmallest","popSmallest","popSmallest","popSmallest","popSmallest","addBack","popSmallest","popSmallest","popSmallest","addBack","addBack","popSmallest","popSmallest","addBack","addBack","popSmallest","popSmallest","addBack","addBack","addBack","addBack","addBack","popSmallest","addBack","popSmallest","popSmallest","popSmallest","addBack","addBack","addBack","popSmallest","addBack","popSmallest","addBack","addBack","popSmallest","popSmallest","addBack","popSmallest","addBack","popSmallest","popSmallest","popSmallest","popSmallest","popSmallest","popSmallest","addBack","popSmallest","addBack","addBack","popSmallest","addBack","popSmallest","popSmallest","addBack","addBack","addBack","addBack","popSmallest","addBack","popSmallest","popSmallest","addBack","popSmallest","addBack","popSmallest","popSmallest","popSmallest","popSmallest","addBack","popSmallest","popSmallest","addBack","addBack","addBack","popSmallest","addBack","addBack","popSmallest","addBack","popSmallest","popSmallest","popSmallest","popSmallest","addBack","addBack","popSmallest","addBack","popSmallest","addBack","addBack","addBack","addBack","popSmallest","popSmallest","popSmallest","addBack","addBack","addBack","popSmallest","addBack","popSmallest","popSmallest","popSmallest","addBack","popSmallest","popSmallest","addBack","addBack","addBack","popSmallest","popSmallest","popSmallest","popSmallest","addBack","popSmallest","popSmallest","popSmallest","addBack","popSmallest","addBack","addBack","addBack","popSmallest","addBack","addBack","popSmallest","popSmallest","popSmallest","addBack","popSmallest","popSmallest","addBack","addBack","addBack","popSmallest","popSmallest","addBack","addBack","addBack","popSmallest","popSmallest","popSmallest","popSmallest","popSmallest","popSmallest","popSmallest","popSmallest","addBack","popSmallest","popSmallest","popSmallest","addBack","addBack","popSmallest","popSmallest","addBack","addBack","addBack","popSmallest","popSmallest","popSmallest","popSmallest","addBack","addBack","addBack","addBack","addBack","addBack","popSmallest","popSmallest","addBack","popSmallest","addBack","addBack","popSmallest","popSmallest","popSmallest","popSmallest","addBack","popSmallest","addBack","addBack","addBack","popSmallest","popSmallest","popSmallest","addBack","popSmallest","addBack","popSmallest","popSmallest","addBack","popSmallest","addBack","addBack","addBack","addBack","addBack","addBack","addBack","popSmallest","popSmallest","addBack","popSmallest","popSmallest","addBack","addBack","popSmallest","addBack","addBack","addBack","addBack","popSmallest","addBack","addBack","popSmallest","popSmallest","addBack","popSmallest","addBack","addBack","popSmallest","addBack","addBack","addBack","addBack","popSmallest","addBack","addBack","addBack","addBack","addBack","addBack","popSmallest","popSmallest","addBack","addBack","addBack","popSmallest","popSmallest","addBack","popSmallest","popSmallest","addBack","popSmallest","popSmallest","addBack","addBack","addBack","addBack","addBack","addBack","popSmallest","addBack","addBack","popSmallest","addBack","addBack","popSmallest","addBack","popSmallest","popSmallest","addBack","addBack","addBack","addBack","addBack","popSmallest","popSmallest","popSmallest","addBack","popSmallest","popSmallest","addBack","popSmallest","popSmallest","addBack","popSmallest","popSmallest","addBack","addBack","addBack","popSmallest","addBack","addBack","addBack","popSmallest","popSmallest","addBack","popSmallest","addBack","popSmallest","popSmallest","addBack","addBack","addBack","popSmallest","addBack","addBack","addBack","addBack","addBack","addBack","addBack","addBack","popSmallest","popSmallest","addBack","popSmallest","addBack","addBack","addBack","addBack","addBack","addBack","addBack","addBack","popSmallest","popSmallest","addBack","popSmallest","popSmallest","addBack","popSmallest","popSmallest","addBack","popSmallest","popSmallest","addBack","addBack","popSmallest","popSmallest","addBack","addBack","popSmallest","popSmallest","addBack","addBack","popSmallest","addBack","popSmallest","addBack","popSmallest","addBack","popSmallest","addBack","addBack","addBack","popSmallest","popSmallest","addBack","popSmallest","addBack","addBack","popSmallest","addBack","addBack","addBack","addBack","addBack"})));

    }
}
