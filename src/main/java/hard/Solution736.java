package hard;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjun
 * @since 2022/7/6 12:48
 */
public class Solution736 {
    int start;

    public int evaluate(String expression) {
        start = 0;
        return evaluate(expression.toCharArray(), Collections.emptyMap());
    }

    private int evaluate(char[] expression, Map<String, Integer> scope) {
        start++;
        int result = 0;
        switch (expression[start]) {
            case 'l':
                Map<String, Integer> newScope = new HashMap<>(scope);
                int value = 0;
                String token;
                start += 4;
                while (start != expression.length && expression[start] != ')') {
                    token = getToken(expression);
                    if(expression[start] == ')'){
                        break;
                    } else if (expression[start] == '(') {
                        value = evaluate(expression, newScope);
                        newScope.put(token, value);
                    } else {
                        while(expression[start] == '-' || expression[start] >= '0' && expression[start] <= '9'){
                            value = getValue(expression);
                        }
                        newScope.put(token, value);
                    }
                    if (expression[start] == '(') {
                        value = evaluate(expression, newScope);
                        break;
                    }
                }
                result = value;
                break;
            case 'a':
                start += 4;
                result = getValue(expression, scope) + getValue(expression, scope);
                break;
            case 'm':
                start += 5;
                result = getValue(expression, scope) * getValue(expression, scope);
                break;
        }
        start++;
        if(start < expression.length && expression[start] == ' '){
            start++;
        }
        return result;
    }

    private int getValue(char[] expression) {
        int value = 0;
        int sign = 1;
        if(expression[start] == '-'){
            sign = -1;
            start++;
        }
        while (expression[start] != ' ' && expression[start] != ')') {
            value = value * 10 + (expression[start++] - '0');
        }
        if (expression[start] == ' ') {
            start++;
        }
        return value * sign;
    }

    private String getToken(char[] expression) {
        String token;
        int s = start;
        while (expression[start] != ' ' && expression[start] != ')') {
            start++;
        }
        token = new String(expression, s, start - s);
        if (expression[start] == ' ') {
            start++;
        }
        return token;
    }

    private int getValue(char[] expression, Map<String, Integer> scope) {
        int result;
        if (expression[start] == '(') {
            result = evaluate(expression, scope);
        } else if (expression[start] >= 'a') {
            result = scope.get(getToken(expression));
        } else {
            result = getValue(expression);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution736 s = new Solution736();
        System.out.println(s.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))") == 14);
        System.out.println(s.evaluate("(add 3 5)") == 8);
        System.out.println(s.evaluate("(let x 3 x 2 x)") == 2);
        System.out.println(s.evaluate("(let x 1 y 2 x (add x y) (add x y))") == 5);
        System.out.println(s.evaluate("(let x 7 -12)") == -12);
        System.out.println(s.evaluate("(let x -2 y x y)") == -2);
        System.out.println(s.evaluate("(let var 78 b 77 (let c 33 (add c (mult var 66))))") == 5181);
    }
}
