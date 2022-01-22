package medium;


import java.io.FileNotFoundException;

/**
 * @author zhangjun
 * @version 2022/1/19
 */
public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int length = nums.length;
        if (k >= length) {
            k = length - 1;
        }
        for (int i = 0; i <= k; i++) {
            long j = (long) nums[i] + t;
            if (contains(nums[i], j)) {
                return true;
            }
            put(nums[i], j);
        }
        k += 1;
        for (int i = k, j; i < length; i++) {
            j = i - k;
            remove(nums[j], (long) nums[j] + t);
            long l = nums[i] + t;
            if (contains(nums[i], l)) {
                return true;
            }
            put(nums[i], l);
        }
        return false;
    }

    // 基于红黑树的区间树

    private static class Node {

        private long lo;

        private long hi;

        private long max;

        private Node parent;

        private Node left;

        private Node right;

        private boolean color;

        public Node(long lo, long hi, Node parent,boolean color) {
            this.lo = lo;
            this.hi = hi;
            max = hi;
            this.parent = parent;
            this.color = color;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getParent() {
            return parent;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public long getLo() {
            return lo;
        }

        public long getHi() {
            return hi;
        }

        public long getMax() {
            return max;
        }

        public boolean isRed() {
            return color;
        }

        public void setMax(long max) {
            this.max = max;
        }

        public void setColor(boolean color) {
            this.color = color;
        }

        public void setLo(int lo) {
            this.lo = lo;
        }

        public void setHi(int hi) {
            this.hi = hi;
        }
    }

    private Node root;

    private boolean isRed(Node x) {
        return x != null && x.isRed();
    }

    private void leftRotate(Node x) {
        //x.right不能为null
        Node right = x.getRight();
        x.setRight(right.getLeft());
        if (right.getLeft() != null) {
            right.getLeft().setParent(x);
        }
        right.setLeft(x);
        Node parent = x.getParent();
        right.setParent(parent);
        if (parent == null) {
            root = right;
        } else if (parent.getLeft() == x) {
            parent.setLeft(right);
        } else {
            parent.setRight(right);
        }
        x.setParent(right);
    }

    private void rightRotate(Node x) {
        //x.left不能为null
        Node left = x.getLeft();
        x.setLeft(left.getRight());
        if (left.getRight() != null) {
            left.getRight().setParent(x);
        }
        left.setRight(x);
        Node parent = x.getParent();
        left.setParent(x.getParent());
        if (parent == null) {
            root = left;
        } else if (parent.getLeft() == x) {
            parent.setLeft(left);
        } else {
            parent.setRight(left);
        }
        x.setParent(left);
    }
    
    private void put(long lo, long hi) {
        Node parent = null;
        Node current = root;
        while (current != null) {
            parent = current;
            if (hi > current.getMax()) {
                current.setMax(hi);
            }
            if (current.getLo() < lo) {
                current = current.getRight();
            } else {
                current = current.getLeft();
            }
        }

        Node x = new Node(lo, hi, parent,true);
        if (parent == null) {
            root = x;
        } else if (parent.getLo() < lo) {
            parent.setRight(x);
        } else {
            parent.setLeft(x);
        }
        putFix(x);
    }

    private void putFix(Node x) {
        Node parent;
        while (isRed(parent = x.getParent())) {
            Node grandparent = parent.getParent();
            if (grandparent.getLeft() == parent) {
                Node uncle = grandparent.getRight();
                if (isRed(uncle)) {
                    uncle.setColor(false);
                    parent.setColor(false);
                    grandparent.setColor(true);
                    x = grandparent;
                } else {
                    if (parent.getRight() == x) {
                        x = parent;
                        leftRotate(parent);
                        parent = x.getParent();
                    }
                    grandparent.setColor(true);
                    parent.setColor(false);
                    rightRotate(grandparent);
                }
            } else {
                Node uncle = grandparent.getLeft();
                if (isRed(uncle)) {
                    uncle.setColor(false);
                    parent.setColor(false);
                    grandparent.setColor(true);
                    x = grandparent;
                } else {
                    if (parent.getLeft() == x) {
                        x = parent;
                        rightRotate(parent);
                        parent = x.getParent();
                    }
                    grandparent.setColor(true);
                    parent.setColor(false);
                    leftRotate(grandparent);
                }
            }
        }
        root.setColor(false);
    }

    private void translate(Node old, Node newNode) {
        if (old.getParent() == null) {
            root = newNode;
        } else if (old.getParent().getLeft() == old) {
            old.getParent().setLeft(newNode);
        } else {
            old.getParent().setRight(newNode);
        }
        if (newNode != null) {
            newNode.setParent(old.getParent());
        }
    }

    private Node getMiniMum(Node x) {
        while (x.getLeft() != null) {
            x = x.getLeft();
        }
        return x;
    }

    private void remove(long lo, long hi) {
        Node old = get(lo, hi);
        if (old == null) {
            return;
        }
        Node parent = old.getParent();
        Node x;
        boolean color = old.isRed();
        if (old.getLeft() == null) {
            x = old.getRight();
            translate(old, x);
        } else if (old.getRight() == null) {
            x = old.getLeft();
            translate(old, x);
        } else {
            Node miniMum = getMiniMum(old.getRight());
            x = miniMum.getRight();
            parent = miniMum;
            color = miniMum.isRed();
            if (miniMum.getParent() != old) {
                parent = miniMum.getParent();
                translate(miniMum, miniMum.getRight());
                miniMum.setRight(old.getRight());
                old.getRight().setParent(miniMum);
            }
            translate(old, miniMum);
            miniMum.setLeft(old.getLeft());
            old.getLeft().setParent(miniMum);
            miniMum.setColor(old.isRed());
        }
        if (!color) {
            removeFix(x, parent);
        }
    }

    private void removeFix(Node x, Node parent) {
        while (!isRed(x) && x != root) {
            if (parent.getLeft() == x) {
                Node brother = parent.getRight();
                if (isRed(brother)) {
                    brother.setColor(false);
                    parent.setColor(true);
                    leftRotate(parent);
                    brother = parent.getRight();
                }
                if (!isRed(brother.getLeft()) && !isRed(brother.getRight())) {
                    brother.setColor(true);
                    x = parent;
                    parent = x.getParent();
                } else {
                    if (!isRed(brother.getRight())) {
                        brother.getLeft().setColor(false);
                        brother.setColor(true);
                        rightRotate(brother);
                        brother = brother.getParent();
                    }
                    brother.setColor(parent.isRed());
                    parent.setColor(false);
                    brother.getRight().setColor(false);
                    leftRotate(parent);
                    x = root;
                }
            } else {
                Node brother = parent.getLeft();
                if (isRed(brother)) {
                    brother.setColor(false);
                    parent.setColor(true);
                    rightRotate(parent);
                    brother = parent.getLeft();
                }
                if (!isRed(brother.getLeft()) && !isRed(brother.getRight())) {
                    brother.setColor(true);
                    x = parent;
                    parent = x.getParent();
                } else {
                    if (!isRed(brother.getLeft())) {
                        brother.getRight().setColor(false);
                        brother.setColor(true);
                        leftRotate(brother);
                        brother = brother.getParent();
                    }
                    brother.setColor(parent.isRed());
                    parent.setColor(false);
                    brother.getLeft().setColor(false);
                    rightRotate(parent);
                    x = root;
                }
            }
        }
        if (x != null) {
            x.setColor(false);
        }
    }

    private Node get(long lo, long hi) {
        Node current = root;
        while (current != null) {
            if (current.getLo() > lo) {
                current = current.getLeft();
            } else if (current.getLo() < lo) {
                current = current.getRight();
            } else {
                if (current.getHi() == hi) {
                    return current;
                }
                current = current.getLeft();
            }
        }
        return null;
    }

    private boolean contains(long lo, long hi) {
        Node current = root;
        while (current != null) {
            if (overlap(current, lo, hi)) {
                return true;
            }
            if (current.getLeft() != null && current.getLeft().getMax() >= lo) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return false;
    }

    private boolean overlap(Node x, long lo, long hi) {
        return x.getLo() <= hi && lo <= x.getHi();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Solution220 s = new Solution220();
        System.out.println(!s.containsNearbyAlmostDuplicate(new int[]{0,10,22,15,0,5,22,12,1,5}, 3, 3));
        System.out.println(!s.containsNearbyAlmostDuplicate(new int[]{1, 3, 1}, 1, 1));
        System.out.println(s.containsNearbyAlmostDuplicate(new int[]{2147483640, 2147483641}, 1, 100));
        System.out.println(s.containsNearbyAlmostDuplicate(new int[]{1, 3, 6, 2}, 1, 2));
        System.out.println(s.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
        System.out.println(s.containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2));
        System.out.println(!s.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
    }


}
