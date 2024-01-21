package org.practice.leetcode.stack;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> values = new Stack();
        int sign = 1;
        int n = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                n = n * 10 + (c - '0');
            } else if (c == '+') {
                res += sign * n;
                sign = 1;
                n = 0;
            } else if (c == '-') {
                res += sign * n;
                sign = -1;
                n = 0;
            } else if (c == '(') {
                res += sign * n;
                values.push(res);
                values.push(sign);
                res = 0;
                sign = 1;
                n = 0;
            } else if (c == ')') {
                res += sign * n;
                res *= values.pop();
                res += values.pop();
                sign = 1;
                n = 0;
            }
        }
        if (n != 0) res += sign * n;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate("1 + 1"));
        System.out.println(new BasicCalculator().calculate(" 2-1 + 2 "));
        System.out.println(new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(new BasicCalculator().calculate("1 - (-2)"));
        System.out.println(new BasicCalculator().calculate("1 - 1"));
    }
}
