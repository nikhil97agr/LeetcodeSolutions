package remove_k_digits_402;

import java.util.*;
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (stack.peek() > c && k > 0) {
                stack.pop();
                k--;
                i--;
            } else {
                stack.push(c);
            }
        }
        char ch[] = new char[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            ch[i] = stack.pop();
            i--;
        }
        for (char c = '9'; c >= '0' && k > 0; c--) {
            for (i = 0; i < ch.length && k > 0; i++) {
                if (ch[i] == c) {
                    ch[i] = ' ';
                    k--;
                }
            }
        }

        i = 0;
        while (i < ch.length && (ch[i]==' ' || ch[i] == '0')) {
            ch[i] = ' ';
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            if (c != ' ') {
                sb.append(c);
            }
        }
        if (sb.isEmpty())
            return "0";
        return sb.toString();

    }
}