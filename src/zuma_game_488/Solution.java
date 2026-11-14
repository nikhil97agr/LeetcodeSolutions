package zuma_game_488;

import java.util.*;
class Solution {
    public int findMinStep(String board, String hand) {
        int cn[] = new int[255];
        for(char c : hand.toCharArray()){
            cn[c]++;
        }
        Queue<String[]> que= new LinkedList<>();
        Set<String> visited = new HashSet<>();
        que.offer(new String[]{board, hand});
        int cnt = 0;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                String next[] = que.poll();
                String b = clean(next[0]);
                if(b.isEmpty()) return cnt;
                String h = next[1];

                for(int i=0;i<=b.length();i++){
                    for(char c : h.toCharArray()){

                        if(cn[c] == 1 && i > 1 && i < b.length()-1 && b.charAt(i) != c && b.charAt(i+1) != c){
                            continue;
                        }
                        String newB = b.substring(0, i) + c + b.substring(i);
                        if(!visited.contains(newB)){
                            String newH = clean(h, c);
                            visited.add(newB);
                            que.offer(new String[]{newB, newH});
                        }
                    }
                }

            }
            cnt++;
        }

        return -1;
    }

    private String clean(String h, char c){
        StringBuilder sb = new StringBuilder(h);
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i) == c){
                sb.deleteCharAt(i);
                return sb.toString();
            }
        }

        return sb.toString();
    }

    private String clean(String s){
        if(s.isEmpty()) return s;
        int start=0;
        int end = 0;
        for(;end < s.length();end++){
            if(s.charAt(start) == s.charAt(end)) continue;

            if( end- start >= 3){
                return clean(s.substring(0, start) + s.substring(end));
            }else{
                start= end;
            }
        }

        if(end - start >= 3){
            return clean(s.substring(0, start));
        }

        return s;
    }
}