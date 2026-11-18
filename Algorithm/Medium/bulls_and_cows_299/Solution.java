package bulls_and_cows_299;

import java.util.*;
class Solution {
    public String getHint(String secret, String guess) {
        int n = guess.length();
        boolean bull[] = new boolean[n];
        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bull[i] = true;
                cnt++;
            }else{
                map.merge(guess.charAt(i), 1, Integer::sum);
            }

            
        }
        int cnt1 = 0;
        for(int i=0;i<n;i++){
            if(!bull[i] && map.containsKey(secret.charAt(i))){
                cnt1++;
                char ch = secret.charAt(i);

                map.merge(ch, -1, Integer::sum);

                if(map.get(ch) ==0) map.remove(ch);
            }
        }
        return ""+cnt+"A"+cnt1+"B";
    }
}