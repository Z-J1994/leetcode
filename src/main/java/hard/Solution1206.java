package hard;

public class Solution1206 {

    private static class Skiplist {

        private final SkipListNode head;

        private final double p;

        private final int MAX_LEVEL;

        private int level;

        public Skiplist() {
            MAX_LEVEL = 10;
            p = 0.25;
            level = 0;
            head = new SkipListNode(-1, MAX_LEVEL);
        }

        public boolean search(int target) {
            SkipListNode current = head;
            for (int i = level - 1; i >= 0; i--) {
                while (current.forward[i] != null && current.forward[i].key < target) {
                    current = current.forward[i];
                }
                if (current.forward[i] != null && current.forward[i].key == target) {
                    return true;
                }
            }
            return current.forward[0] != null && current.forward[0].key == target;
        }

        public void add(int num) {
            SkipListNode current = head;
            SkipListNode[] updated = new SkipListNode[MAX_LEVEL];
            for (int i = level - 1; i >= 0; i--) {
                while (current.forward[i] != null && current.forward[i].key < num) {
                    current = current.forward[i];
                }
                updated[i] = current;
            }

            int nLevel = getLevel();
            if (nLevel > level) {
                for (int i = level; i < nLevel; i++) {
                    updated[i] = head;
                }
                level = nLevel;
            }

            SkipListNode nodeToBeAdd = new SkipListNode(num, nLevel);
            for (int i = 0; i < nLevel; i++) {
                nodeToBeAdd.forward[i] = updated[i].forward[i];
                updated[i].forward[i] = nodeToBeAdd;
            }
        }

        public boolean erase(int num) {
            SkipListNode current = head;
            SkipListNode[] updated = new SkipListNode[MAX_LEVEL];
            for (int i = level - 1; i >= 0; i--) {
                while (current.forward[i] != null && current.forward[i].key < num) {
                    current = current.forward[i];
                }
                updated[i] = current;
            }

            SkipListNode nodeToBeRemove = current.forward[0];
            if (nodeToBeRemove != null && nodeToBeRemove.key == num) {
                for (int i = 0; i < level && updated[i].forward[i] == nodeToBeRemove; i++) {
                    updated[i].forward[i] = nodeToBeRemove.forward[i];
                }
                while (level > 1 && head.forward[level - 1] == null) {
                    level--;
                }
                return true;
            }
            return false;
        }

        private int getLevel() {
            int level = 1;
            while (Math.random() < p && level < MAX_LEVEL) {
                level++;
            }
            return level;
        }

        private static class SkipListNode {

            private final int key;

            private final SkipListNode[] forward;

            public SkipListNode(int key, int level) {
                this.key = key;
                this.forward = new SkipListNode[level];
            }
        }

    }


    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);

        System.out.println(skiplist.search(0));

        skiplist.add(4);

        System.out.println(skiplist.search(1));

        System.out.println(skiplist.erase(0));
        System.out.println(skiplist.erase(1));

        System.out.println(skiplist.search(1));
    }
}
