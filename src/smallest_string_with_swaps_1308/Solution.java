package smallest_string_with_swaps_1308;

import java.util.*;
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char ch[] = s.toCharArray();
        int n = s.length();

        int par[] = new int[n];
        for(int i=0;i<n;i++) par[i] = i;

        for(List<Integer> p : pairs){
            int p1 = findParent(par, p.get(0));
            int p2 = findParent(par, p.get(1));

            if(p1 != p2){
                par[p1] = p2;
            }
        }
        Map<Integer, List<Integer>> m2= new HashMap<>();
        Map<Integer, List<Character>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int p = findParent(par, i);
            m2.computeIfAbsent(p, j -> new ArrayList<>()).add(i);
            map.computeIfAbsent(p, j -> new ArrayList<>()).add(ch[i]);
        }

        for(int p : map.keySet()){
            List<Character> l1 = map.get(p);
            List<Integer> l2 = m2.get(p);

            Collections.sort(l1);
            for(int i=0;i<l2.size();i++){
                ch[l2.get(i)] = l1.get(i);
            }
        }

        return new String(ch);
    }

    private int findParent(int par[], int i){
        if(par[i] == i) return i;
        return par[i] = findParent(par, par[i]);
    }
}