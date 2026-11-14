package remove_colored_pieces_if_both_neighbors_are_the_same_color_2149;

import java.util.*;
class Solution {
    public boolean winnerOfGame(String colors) {
        if (colors.length() < 3) {
            return false;
        }
        int bcnt = 0;
        int acnt = 0;

        Stack<Character> stack = new Stack<>();
        for (char c : colors.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (stack.peek() == c) {
                stack.push(c);
                continue;
            }
            if (c == 'B') {
                acnt += Math.max(0, stack.size() - 2);
            } else {
                bcnt += Math.max(0, stack.size() - 2);
            }
            stack.clear();
            stack.push(c);
        }

        if (stack.peek() == 'B') {
            bcnt += Math.max(0, stack.size() - 2);
        } else {
            acnt += Math.max(0, stack.size() - 2);
        }

        return acnt > bcnt;
    }
}