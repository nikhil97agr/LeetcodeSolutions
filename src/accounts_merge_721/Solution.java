package accounts_merge_721;

import java.util.*;
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, Integer> par = new HashMap<>();
        int n = accounts.size();

        for(int i=0;i<n;i++){
            par.put(i,i);
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);

                if(!map.containsKey(mail)){
                    int p = find(i, par);
                    map.put(mail, p);
                }else{
                    int p = map.get(mail);
                    int p1 = find(p, par);
                    int p2 = find(i, par);
                    if(p1!=p2)
                    {
                        par.put(p2, p1);
                    }
                }
            }
        }
        Map<Integer, List<String>> result = new HashMap<>();
        for(String mail : map.keySet() ){
            int p =find(map.get(mail), par);
            result.computeIfAbsent(p, x-> new ArrayList<>()).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int p : result.keySet()){
            List<String> list = new ArrayList<>();
            list.add(accounts.get(p).get(0));
            List<String>temp = result.get(p);
            Collections.sort(temp);
            list.addAll(temp);
            ans.add(list);
        }

        return ans;
        
    }

    private int find(int curr, Map<Integer, Integer> par){
        if(par.get(curr) == curr) return curr;
        int next = find(par.get(curr), par);
        par.put(curr, next);
        return next;
    }
}