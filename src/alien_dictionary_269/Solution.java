package alien_dictionary_269;

import java.util.*;
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        if(words==null || words.length==0) return "";
        StringBuilder result = new StringBuilder();
        for(String s : words){
            for(char c : s.toCharArray()){
                indegree.put(c, 0);
            }
        }
        int n = words.length;
        for(int i=0;i<n-1;i++){
            String prev = words[i];
            String next = words[i+1];
            int j=0;
            int k=0;
            while(j<prev.length() && k<next.length()){
                char c1 = prev.charAt(j);
                char c2 = next.charAt(k);

                if(c1!=c2){
                    Set<Character> set = new HashSet<>();
                    if(map.containsKey(c1)) set = map.get(c1);

                    if(!set.contains(c2)){
                        set.add(c2);
                        indegree.put(c2, indegree.getOrDefault(c2,0)+1);
                        map.put(c1, set);
                    }

                    break;

                }
                j++;k++;

            }

            if(k==next.length() && j!=prev.length()) return "";


        }

        final Queue<Character> que = new LinkedList<>();
        indegree.forEach((k,v)->{
            if(v==0) que.offer(k);
        }); 

        while(!que.isEmpty()){
            char ch = que.poll();
            result.append(ch);
            for(char c : map.getOrDefault(ch, new HashSet<>())){
                indegree.put(c, indegree.get(c)-1);
                if(indegree.get(c)==0){
                    que.offer(c);
                }
            }
        }

        return (result.length()!=indegree.size()) ? "" : result.toString();
    }
}