package minimum_number_of_keypresses_2405;

import java.util.*;
class Solution {
    public int minimumKeypresses(String s) {
        int ans = 0;
        int cnt[] = new int[26];
        for(char c : s.toCharArray()) cnt[c-'a']++;
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : cnt){
            if(x!=0) que.offer(x);

        }
        int len = 1;
        int c = 0;
        while(!que.isEmpty()){
            int x = que.poll();
            ans += len*x;
            c++;
            if(c==9){
                len++;
                c = 0;
            }
        }
        return ans;
        
    }

}