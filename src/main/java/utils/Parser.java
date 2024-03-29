package utils;

import list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static int[][] stringToIntMatrix(String s, int row, int column) {
        List<int[]> result = new ArrayList<>();
        char c;
        for (int i = 2, r = 0; r < row; i += 2, r++) {
            int[] element = new int[column];
            for (int j = 0; j < column; j++) {
                int sign = 1;
                if (!((c = s.charAt(i)) >= '0' && c <= '9')) {
                    if (c != '-') {
                        throw new IllegalArgumentException("只能包含数字");
                    }
                    sign = -1;
                    i++;
                }
                while ((c = s.charAt(i)) >= '0' && c <= '9') {
                    element[j] = element[j] * 10 + c - '0';
                    i++;
                }
                element[j] *= sign;
                i++;
            }
            result.add(element);
        }
        return result.toArray(new int[result.size()][]);
    }

    public static int[] StringToIntArray(String s) {
        int l = 0;
        int lastIndex = s.length() - 1;
        for (int i = 1; i < lastIndex; i++) {
            if (s.charAt(i) == ',') {
                l++;
            }
        }
        int[] result = new int[l + 1];
        int index = 0;
        int n = 0;
        int sign = 1;
        for (int i = 1; i < lastIndex; i++) {
            char c = s.charAt(i);
            if (c == '-') {
                sign = -1;
            } else if (c == ',') {
                result[index++] = n * sign;
                n = 0;
                sign = 1;
            } else if (c != ' ') {
                n = n * 10 + c - 48;
            }
        }
        result[index] = n * sign;
        return result;
    }

    public static Integer[] StringToIntegerArray(String s) {
        int l = 0;
        int lastIndex = s.length() - 1;
        for (int i = 1; i < lastIndex; i++) {
            if (s.charAt(i) == ',') {
                l++;
            }
        }
        Integer[] result = new Integer[l + 1];
        int index = 0;
        int n = 0;
        int sign = 1;
        for (int i = 1; i < lastIndex; i++) {
            char c = s.charAt(i);
            if (c == '-') {
                sign = -1;
            } else if (c == ',') {
                result[index++] = n * sign;
                n = 0;
                sign = 1;
            } else if (c == 'n') {
                i += 4;
                result[index++] = null;
            } else if (c != ' ') {
                n = n * 10 + c - 48;
            }
        }
        result[index] = n * sign;
        return result;
    }

    public static ListNode toList(String s) {
        int n = 0, sign = 1;
        Integer v = null;
        ListNode listNode = new ListNode();
        ListNode p = listNode;
        for (int i = 1, length = s.length() - 1; i < length; i++) {
            char c = s.charAt(i);
            if (c == '-') {
                sign = -1;
            } else if (c == ',') {
                v = n * sign;
                ListNode l = new ListNode(v);
                p.next = l;
                p = l;
                n = 0;
                sign = 1;
            }  else if (c != ' ') {
                n = n * 10 + c - 48;
            }
        }
        p.next = new ListNode(n * sign);
        return listNode.next;
    }
}
