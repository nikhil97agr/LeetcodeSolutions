package the_k_th_lexicographical_string_of_all_happy_strings_of_length_n_1516;

import java.util.*;
class Solution {
    public String getHappyString(int n, int k) {
        Queue<String> que = new LinkedList<>();
        for(char c = 'a';c<='c';c++){
            que.offer(""+c);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        while(!que.isEmpty()){
            String s = que.poll();
            
            if(s.length() == n){
                if(cnt == k-1) return s;
                cnt++;
                continue;
            }
            int c = map.getOrDefault(s.length(),0);
             if(c == k){
                continue;
             }
             map.put(s.length(), c + 1);

            switch(s.charAt(s.length()-1)){
                case 'a':
                que.offer(s+"b");
                que.offer(s+"c");
                break;
            
                case 'b':
                que.offer(s+"a");
                que.offer(s+"c");
                break;
                case 'c':
                que.offer(s+"a");
                que.offer(s+"b");
                break;
            }
        }

        return "";
    }






}