package subdomain_visit_count_829;

import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : cpdomains){
            String st[] = s.split(" ");

            int cnt = Integer.parseInt(st[0]);

            StringBuilder sb = new StringBuilder(st[1]);

            solve(sb, map, cnt);

        }

        List<String> res = new ArrayList<>();

        for(String key : map.keySet()){
            String sb = map.get(key) + " " + key;
           res.add(sb);
        }

        return res;
    }

    private void solve(StringBuilder sb, Map<String, Integer> map, int n) {
        map.merge(sb.toString(), n, Integer::sum);
        int ind = sb.indexOf(".");
        if(ind == -1) return;
        
        solve(new StringBuilder(sb.substring(ind+1)), map, n);

    }
}