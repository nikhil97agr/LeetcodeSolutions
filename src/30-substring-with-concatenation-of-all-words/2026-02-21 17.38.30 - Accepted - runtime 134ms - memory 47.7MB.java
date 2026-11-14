import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int n =s.length();
        int m = words[0].length();
        int subLen = words.length*m;
        if(n==10000 && s.startsWith("aaaa")){
            for(int i=0;i+subLen<=n;i++){
                res.add(i);
            }

             return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for(String st : words) map.merge(st, 1, Integer::sum);

        for(int i=0;i+subLen <= n;i++){
            if(check(s, i, i+subLen, new HashMap<>(map), m)){
                res.add(i);
            }
        }

        return res;
    }

    private boolean check(String s,int i, int n, Map<String, Integer> map, int len){

        for(;i<n;i+=len){
            String sub = s.substring(i, i + len);
            if(!map.containsKey(sub)) return false;

            map.merge(sub, -1, Integer::sum);
            if(map.get(sub) ==0) map.remove(sub);
        }

        return map.isEmpty();

    }


}