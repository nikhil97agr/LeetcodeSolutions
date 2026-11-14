package implement_trie_prefix_tree_208;

import java.util.*;
class Trie {
    Map<Character, Trie> map;
    boolean isLast;
    public Trie() {
        map = new HashMap<Character, Trie>();
        isLast = false;
    }
    
    public void insert(String word) {
        this.insert(word, 0);
    }
    
    public void insert(String word, int ind){
        if(ind==word.length()){
            this.isLast = true;
            return;
        }
        Trie trie = map.get(word.charAt(ind));
        if(trie==null){
            trie = new Trie();
            map.put(word.charAt(ind), trie);
            trie.insert(word, ind+1);
        }else{
            trie.insert(word, ind+1);
        }
        
    }
    
    public boolean search(String word) {
        return this.search(word, 0, false);
        
    }
    public boolean search(String word, int ind, boolean isPrefix){
        if(ind==word.length()){
            if(isPrefix){
                return true;
            }
            return isLast;
        }
        Trie trie = map.get(word.charAt(ind));
        if(trie==null){
            return false;
        }
        return trie.search(word, ind+1, isPrefix);
    }
    
    public boolean startsWith(String prefix) {
        return this.search(prefix, 0, true);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */