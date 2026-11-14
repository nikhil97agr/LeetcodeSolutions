package next_closest_time_681;

import java.util.*;
class Solution {
    public String nextClosestTime(String time) {
        
        String t[] = time.split(":");
        Set<Character> dig =new HashSet<>();
        for(char c : time.toCharArray()){
            if(c != ':'){
                dig.add(c);
            }
        }
        int curr = Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
        int sec = curr + 1;
        while(sec != curr){
                String temp = generate(sec);
                boolean pos = true;
                for(char c : temp.toCharArray()){
                    if(c != ':' && !dig.contains(c)){
                        pos = false;
                        break;
                    }
                }

                if(pos && curr != sec){
                    return temp;
                }
            sec++;
            if(sec > 1440){
                sec = 0;
            }



        }
        return time;
    }

    private String generate(int sec){
        int hr= sec/60;
        int min = sec%60;
        return "" + (hr < 10 ? "0": "")+hr+ ":"+ (min < 10 ? "0": "") + min;

    }
}