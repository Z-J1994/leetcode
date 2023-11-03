package utils;

import tree.TreeNode;

import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Function;

public class TreeUtil {

    public static TreeNode from(Integer[] data) {
        if (data.length == 0) {
            return null;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(data[0]);
        queue.offer(root);
        for (int i = 1; i < data.length; i++) {
            TreeNode poll = queue.poll();
            if (data[i] != null) {
                TreeNode left = new TreeNode(data[i]);
                poll.left = left;
                queue.offer(left);
            }
            if (++i < data.length && data[i] != null) {
                TreeNode right = new TreeNode(data[i]);
                poll.right = right;
                queue.offer(right);
            }
        }
        return root;
    }

    public static <T> T from(Integer[] data, Function<Integer, T> nodeGetter) {
        if (data.length == 0) {
            return null;
        }
        T root = nodeGetter.apply(data[0]);
        Field leftFiled = null, rightFiled = null;
        for (Field f : root.getClass().getFields()) {
            if (f.getName().equals("left")) {
                leftFiled = f;
            } else if (f.getName().equals("right")) {
                rightFiled = f;
            }
        }
        if (leftFiled == null || rightFiled == null) {
            throw new IllegalArgumentException("没有找到left或right字段");
        }
        leftFiled.setAccessible(true);
        rightFiled.setAccessible(true);

        Deque<T> queue = new ArrayDeque<>();
        queue.offer(root);
        for (int i = 1; i < data.length; i++) {
            T poll = queue.poll();
            if (data[i] != null) {
                T left = nodeGetter.apply(data[i]);
                set(leftFiled, poll, left);
                queue.offer(left);
            }
            if (++i < data.length && data[i] != null) {
                T right = nodeGetter.apply(data[i]);
                set(rightFiled, poll, right);
                queue.offer(right);
            }
        }
        return root;
    }


    private static void set(Field field, Object o, Object value) {
        try {
            field.set(o, value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
