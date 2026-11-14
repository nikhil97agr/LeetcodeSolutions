package map_sum_pairs_677;

import java.util.*;
class MapSum {
    Map<String, Integer> map;
    Trie trie;
    public MapSum() {
        map = new HashMap<>();
        trie = new Trie();
    }
    
    public void insert(String key, int val) {
        if(map.containsKey(key)){
            trie.update(key, 0, key.length(), map.get(key), val);
            map.put(key, val);
        }else{
            map.put(key, val);
            trie.add(key, 0, key.length(), val);
        }
    }
    
    public int sum(String prefix) {
        return trie.search(prefix, 0, prefix.length());
    }
}

class Trie{
    int sum;
    Trie trie[];
    public Trie(){
        this.sum = 0;
        this.trie = new Trie[26];
    }

    public void add(String s, int i, int n, int val){
        sum += val;
        if(i==n) return;
        Trie trie = this.trie[s.charAt(i)-'a'];
        if(trie == null){
            trie = new Trie();
        }
        this.trie[s.charAt(i)-'a'] = trie;
        trie.add(s, i+1, n, val);
    }

    public void update(String s, int i, int n, int old, int newVal){
        sum -= old;
        sum += newVal;

        if(i==n) return;
        
        Trie trie = this.trie[s.charAt(i)-'a'];
        if(trie == null){
            trie = new Trie();
        }

        trie.update(s, i+1, n, old, newVal);
        this.trie[s.charAt(i)-'a'] = trie;

    }

    public int search(String s, int i, int n){
        if(i==n) return sum;

        int ind = s.charAt(i)-'a';
        if(trie[ind]==null) trie[ind] = new Trie();
        return trie[ind].search(s, i+1, n);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */