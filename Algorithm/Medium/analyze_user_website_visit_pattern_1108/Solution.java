package analyze_user_website_visit_pattern_1108;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<String> result = new ArrayList<>();
        int n = username.length;
        Pair pair[] = new Pair[n];
        for(int i=0;i<n;i++){
            pair[i] = new Pair(username[i], timestamp[i], website[i]);
        }

        Arrays.sort(pair, (a,b) -> a.time - b.time);

        Map<String, List<String>> userMap = new HashMap<>();
        for(Pair p : pair){
            userMap.computeIfAbsent(p.user, x -> new ArrayList<>()).add(p.website);
        }

        Map<String, Set<String>> tripletMap =new HashMap<>();
        for(String user : userMap.keySet()){
            List<String> list = userMap.get(user);
            int size = list.size();
            for(int i=0;i<size;i++){
                for(int j=i+1;j<size;j++){
                    for(int k=j+1;k<size;k++){
                        String s = list.get(i)+"-"+list.get(j)+"-"+list.get(k);
                        tripletMap.computeIfAbsent(s, x-> new HashSet<>()).add(user);
                    }
                }
            }
        }
        int score = 0;
        String res = "";
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    String key = website[i]+"-"+website[j]+"-"+website[k];
                    if(!tripletMap.containsKey(key)) continue;
                    int cnt = tripletMap.get(key).size();
                    if(cnt > score){
                        score = cnt;
                        res = key;
                    }else if(cnt == score && key.compareTo(res) < 0){
                        res = key;
                    }
                }
            }
        }
        return Arrays.asList(res.split("-"));
    }

    class Pair{
        String user;
        int time;
        String website;
        public Pair(String user, int time, String website){
            this.user = user;
            this.time = time;
            this.website = website;
        }
    }

}