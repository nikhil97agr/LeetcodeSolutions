package dota2_senate_649;

import java.util.*;
class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qd = new LinkedList<>();
        int n = senate.length();
        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='R'){
                qr.offer(i);
            }else{
                qd.offer(i);
            }
        }

        while(!qr.isEmpty() && !qd.isEmpty()){
            int i = qr.poll();
            int j = qd.poll();
            if(i>j){
                qd.offer(j+n);
            }else{
                qr.offer(i+n);
            }
        }

        return qr.isEmpty() ? "Dire" : "Radiant";
    }
}