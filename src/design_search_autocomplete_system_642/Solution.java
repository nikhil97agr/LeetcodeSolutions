package design_search_autocomplete_system_642;

import java.util.*;

import java.util.Collection;class AutocompleteSystem {
    Trie curr;
    Trie root;
    StringBuilder sb;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        curr = root;
        sb =new StringBuilder();
        for(int i=0;i<times.length;i++){
            add(sentences[i], times[i]);
        }
    }

    private void add(String s, int cnt){
        Trie node = root;
        for(char c : s.toCharArray()){
            node.map.putIfAbsent(c, new Trie());
            node = node.map.get(c);
            node.cnt.merge(s, cnt, Integer::sum);

        }
    }
    
    public List<String> input(char c) {
        if(c == '#'){
            String s = sb.toString();
            sb = new StringBuilder();
            add(s, 1);
            curr = root;
            return new ArrayList<>();
        }
        sb.append(c);
        if(curr != null){
            curr = curr.map.get(c);
        }
        if(curr == null) return new ArrayList<>();
        
        PriorityQueue<String> que =new PriorityQueue<>((s1, s2)->{
            int c1 = curr.cnt.get(s1);
            int c2 = curr.cnt.get(s2);
            if(c1 != c2) return c1 -c2;
            return s2.compareTo(s1);
        });

        for(String key : curr.cnt.keySet()){
            que.offer(key);
            if(que.size() > 3) que.poll();
        }
        List<String> result = new ArrayList<>();
        while(!que.isEmpty()) result.add(que.poll());
        Collections.reverse(result);
        return result;
    }

    class Trie{
        Map<Character, Trie> map;
        Map<String, Integer> cnt;

        public Trie(){
            map =new HashMap<>();
            cnt =new HashMap<>();
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */