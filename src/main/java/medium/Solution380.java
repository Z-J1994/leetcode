package medium;

import java.util.*;

public class Solution380 {
    private static class RandomizedSet {

        private final Map<Integer, Integer> map;
        private int[] elements;
        private int index = 0;

        public RandomizedSet() {
            map = new HashMap<>();
            elements = new int[10];
        }

        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                if (index >= elements.length) {
                    int capacity = elements.length << 1;
                    if (capacity > 20001) {
                        capacity = 20001;
                    }
                    int[] newElements = new int[capacity];
                    System.arraycopy(elements, 0, newElements, 0, elements.length);
                    elements = newElements;
                }
                elements[index] = val;
                map.put(val, index);
                index++;
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            Integer i;
            if ((i = map.remove(val)) != null) {
                int t = elements[--index];
                if (index > i) {
                    elements[index] = elements[i];
                    elements[i] = t;
                    map.put(t, i);
                }
                return true;
            }
            return false;
        }

        public int getRandom() {
            return elements[(int) (Math.random() * index)];
        }
    }
}
