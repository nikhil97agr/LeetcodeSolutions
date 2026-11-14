package design_file_system_1125;

import java.util.*;
class FileSystem {
    Trie trie;
    public FileSystem() {
        trie = new Trie();
        trie.paths.put("", new Trie());
    }
    
    public boolean createPath(String path, int value) {
        String st[] = path.split("/");

        return trie.add(st, 0, value);
    }
    
    public int get(String path) {
        return trie.search(path.split("/"), 0);
    }

    class Trie{
        Map<String, Trie> paths;
        int value;

        public Trie(){
            paths = new HashMap<>();
            value = -1;
        }

        public boolean add(String s[], int i, int val){
            if(i == s.length){
                this.value = val;
                return true;
            }

            Trie trie = new Trie();
            if(paths.containsKey(s[i])){
                if(i==s.length-1) return false;
                trie = paths.get(s[i]);
            }else{
                if(i!=s.length - 1) return false;
                paths.put(s[i], trie);
            }

           return trie.add(s, i+1, val);
        }

        public int search(String s[], int i){
            if(i==s.length) return value;

            if(!paths.containsKey(s[i])) return -1;

            return paths.get(s[i]).search(s,i+1);
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */