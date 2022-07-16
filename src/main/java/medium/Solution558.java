package medium;

/**
 * @author zhangjun
 * @since 2022/7/15 13:17
 */
public class Solution558 {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1 == null) {
            return quadTree2;
        }
        if (quadTree2 == null) {
            return quadTree1;
        }
        if (quadTree1.isLeaf && quadTree1.val) {
            return quadTree1;
        }
        if (quadTree2.isLeaf && quadTree2.val) {
            return quadTree2;
        }
        Node node = new Node();
        node.isLeaf = quadTree1.isLeaf & quadTree2.isLeaf;
        node.val = quadTree1.val | quadTree2.val;
        node.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        node.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        node.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        node.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        boolean b;
        if (node.topLeft != null && node.topLeft.isLeaf && node.topRight.isLeaf && node.bottomLeft.isLeaf && node.bottomRight.isLeaf && (b = node.topLeft.val) == node.bottomLeft.val && b == node.topRight.val && b == node.bottomRight.val) {
            node = new Node();
            node.val = b;
            node.isLeaf = true;
        }
        return node;
    }

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }
    }
}
