package perform_string_shifts_1345;

import java.util.*;
class Solution {
    public String stringShift(String s, int[][] shift) {
        Deque<Character> que = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            que.offerLast(c);
        }

        for(int x[] : shift){
            int dir = x[0];
            int cnt = x[1];

            if(dir == 0){
                while(cnt-- > 0){
                    char c = que.pollFirst();
                    que.offerLast(c);
                }
            }else{
                while(cnt-- > 0){
                    char c = que.pollLast();
                    que.offerFirst(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!que.isEmpty()){
            sb.append(que.pollFirst());
        }
        return sb.toString();
    }
}