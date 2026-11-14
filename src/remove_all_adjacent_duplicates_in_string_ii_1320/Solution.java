package remove_all_adjacent_duplicates_in_string_ii_1320;

import java.util.*;
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(new Pair(c, 1));
                continue;
            }

            if(stack.peek().c == c){
                if(stack.peek().cnt == k-1){
                    stack.pop();
                }else{
                    stack.peek().cnt++;
                }
            }else{
                stack.push(new Pair(c, 1));
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            Pair pair = stack.pop();

            int cnt = pair.cnt;
            char c = pair.c;

            while(cnt-- > 0){
                sb.append(c);
            }
        }

        return sb.reverse().toString();
    }

    class Pair{
        char c;
        int cnt;

        public Pair(char c, int cnt){
            this.c = c;
            this.cnt = cnt;
        }
    }
}