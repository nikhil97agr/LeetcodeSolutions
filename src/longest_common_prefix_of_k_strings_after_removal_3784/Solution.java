package longest_common_prefix_of_k_strings_after_removal_3784;

import java.util.*;
import java.util.TreeMap;

class Solution {

    TreeMap<Integer, Integer> map;

    public int[] longestCommonPrefix(String[] words, int k) {
        Trie trie = new Trie();
        map = new TreeMap<>();
        
        
        int n = words.length;
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            trie.add(words[i].toCharArray(), words[i].length(), k);
        }
        
        for(int i=0;i<n;i++){
            String s = words[i];
            trie.remove(s.toCharArray(), s.length(), k);
            
            if(!map.isEmpty()){
                ans[i] = map.lastKey(); 
            }
            
            trie.add(s.toCharArray(), s.length(), k);
        }
        
        
        return ans;


    }

    public void add(int a) {

        map.merge(a, 1, Integer::sum);
    }

    public void remove(int a) {

        map.merge(a, -1, Integer::sum);
        if (map.get(a) == 0) {
            map.remove(a);
        }
    }

    class Trie {

        int cnt;
        Trie trie[];

        public Trie() {

            trie = new Trie[26];
            cnt = 0;
        }

        public void add(char ch[], int n, int k) {

            Trie root = this;

            for (int i = 0; i < n; i++) {
                int ind = ch[i] - 'a';
                if (root.trie[ind] == null) {
                    root.trie[ind] = new Trie();
                }

                root = root.trie[ind];
                root.cnt++;

                if (root.cnt >= k) {
                    Solution.this.add(i + 1);
                }
            }
        }

        public void remove(char ch[], int n, int k){
            Trie root = this;
            
            for(int i=0;i<n;i++){
                int ind = ch[i] - 'a';
                
                root = root.trie[ind];
                root.cnt--;

                if(root.cnt  == k - 1){
                    Solution.this.remove(i+1);
                }
            }
        }
    }
}