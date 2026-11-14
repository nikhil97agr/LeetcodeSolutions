package rank_teams_by_votes_1483;

import java.util.*;
class Solution {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        int cnt[][] = new int[n][26];

        StringBuilder res = new StringBuilder();

        for(String s : votes){
            for(int i=0;i<n;i++){
                char c = s.charAt(i);
                cnt[i][c-'A']++;
            }
        }
        int i=0;
        while(i < n){
            int max = max(cnt[i]);

            if(max ==0){
                i++;
                continue;
            }

            Set<Character> set = new HashSet<>();
            for(char c= 'A';c<='Z';c++){
                if(cnt[i][c-'A'] == max) set.add(c);
            }
            for(int j=i+1;j<n && set.size() > 1;j++){
                max = 0;
                for(char c : set){
                    max = Math.max(max, cnt[j][c-'A']);
                }

                for(char c = 'A';c<='Z';c++){
                    if(cnt[j][c-'A']!=max){
                        set.remove(c);
                    }
                }
            }
 
            char result = 'Z';
            for(char c : set){
                result = (char)Math.min(result, c);
            }
            
            for(int j=0;j<n;j++){
                cnt[j][result-'A'] = 0;
            }

            res.append(result);
        }

        return res.toString();
    }

    private int max(int cnt[]){
        int max = 0;
        for(int x: cnt){
            max = Math.max(max, x);
        }

        return max;
    }
}