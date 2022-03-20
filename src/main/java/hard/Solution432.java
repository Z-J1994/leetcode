package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjun
 * @version 2022/3/16
 */
public class Solution432 {

    private static class AllOne {

        private static class Node {
            private Node previous;
            private Node next;
            private final String key;
            private int count;

            public Node(String key, int count) {
                this.key = key;
                this.count = count;
            }

            private Node(Node previous, Node next, String key, int count) {
                this.previous = previous;
                this.next = next;
                this.count = count;
                this.key = key;
            }

            private Node increase() {
                count++;
                Node p = previous;
                while (p.count < count) {
                    p = p.previous;
                }
                if (p != previous) {
                    previous.next = next;
                    next.previous = previous;

                    next = p.next;
                    p.next.previous = this;
                    p.next = this;
                    this.previous = p;
                }
                return this;
            }

            private Node decrease() {
                count--;
                if (count == 0) {
                    previous.next = next;
                    next.previous = previous;
                    return this;
                }
                Node n = next;
                while (n.count > count) {
                    n = n.next;
                }
                if (n != next) {
                    previous.next = next;
                    next.previous = previous;

                    previous = n.previous;
                    n.previous.next = this;
                    n.previous = this;
                    next = n;
                }
                return this;
            }
        }

        private final Map<String, Node> map;

        private final Node first;

        private final Node last;

        public AllOne() {
            map = new HashMap<>();
            first = new Node("", 0x7fffffff);
            last = new Node(first, null, "", 0x80000000);
            first.next = last;
        }

        public void inc(String key) {
            Node c = map.get(key);
            if (c == null) {
                map.put(key, addLast(key));
            } else {
                c.increase();
            }
        }

        public void dec(String key) {
            Node node = map.get(key).decrease();
            if (node.count == 0) {
                map.remove(key);
            }
        }

        public String getMaxKey() {
            return first.next.key;
        }

        public String getMinKey() {
            return last.previous.key;
        }

        private Node addLast(String key) {
            Node n = new Node(last.previous, last, key, 1);
            last.previous.next = n;
            last.previous = n;
            return n;
        }
    }

    //["AllOne","inc","inc","inc","inc","inc","inc","getMaxKey","inc","dec","getMaxKey","dec","inc","getMaxKey","inc","inc","dec","dec","dec","dec","getMaxKey","inc","inc","inc","inc","inc","inc","getMaxKey","getMinKey"]
    //[[],["hello"],["world"],["leet"],["code"],["ds"],["leet"],[],["ds"],["leet"],[],["ds"],["hello"],[],["hello"],["hello"],["world"],["leet"],["code"],["ds"],[],["new"],["new"],["new"],["new"],["new"],["new"],[],[]]
    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        String[] commands = {"inc", "inc", "inc", "inc", "inc", "inc", "getMaxKey", "inc", "dec", "getMaxKey", "dec", "inc", "getMaxKey", "inc", "inc", "dec", "dec", "dec", "dec", "getMaxKey", "inc", "inc", "inc", "inc", "inc", "inc", "getMaxKey", "getMinKey"};
        String[] data = {"hello", "world", "leet", "code", "ds", "leet", "", "ds", "leet", "", "ds", "hello", "", "hello", "hello", "world", "leet", "code", "ds", "", "new", "new", "new", "new", "new", "new", "", ""};

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "inc":
                    allOne.inc(data[i]);
                    break;
                case "dec":
                    allOne.dec(data[i]);
                    break;
                case "getMaxKey":
                    System.out.println(allOne.getMaxKey());
                    break;
                case "getMinKey":
                    System.out.println(allOne.getMinKey());
                    break;
                default:
                    throw new RuntimeException();
            }
            System.out.println(i);
        }
    }
}