import java.util.*;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int num = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            else if (ch == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            }
            else if (ch == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            }
            else if (ch == '(') {
                // Save current result and sign
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            }
            else if (ch == ')') {
                result += sign * num;
                num = 0;

                // Apply sign before parentheses
                result *= stack.pop();

                // Add result before parentheses
                result += stack.pop();
            }
        }

        return result + sign * num;
    }
}