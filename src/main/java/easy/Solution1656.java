package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangjun
 * @since 2022/8/16 12:53
 */
public class Solution1656 {
    private static class OrderedStream {

        private final String[] element;
        private int index;

        public OrderedStream(int n) {
            element = new String[n + 1];
            index = 1;
        }

        public List<String> insert(int idKey, String value) {
            element[idKey] = value;
            List<String> result = new ArrayList<>();
            while (index < element.length && element[index] != null) {
                result.add(element[index++]);
            }
            return result;
        }
    }
}
