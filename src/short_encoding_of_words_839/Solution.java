package short_encoding_of_words_839;

import java.util.*;
class Solution {
    class Trie{
        Trie node[];
        boolean isLast;
        Trie(){
            node = new Trie[26];
            isLast = false;
        }

        public boolean contains(String s,int ind){
            if(ind==s.length()) return true;
            if(node[s.charAt(ind)-'a'] == null) return false;

            return node[s.charAt(ind)-'a'].contains(s, ind+1);
        }
        public void add(String s, int ind){
            if(ind == s.length()){
                this.isLast = true;
                return;
            }

            if(node[s.charAt(ind)-'a']==null){
                node[s.charAt(ind)-'a'] = new Trie();
            }

            node[s.charAt(ind)-'a'].add(s, ind+1);
        }
    }
    public int minimumLengthEncoding(String[] words) {
        List<String> result = new ArrayList<>();
        Arrays.sort(words, (a,b)-> b.length() - a.length());
        Trie trie = new Trie();
        for(String s : words){
            String reverse = new StringBuilder(s).reverse().toString();
            if(!trie.contains(reverse, 0)){
                trie.add(reverse, 0);
                result.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s : result){
            sb.append(s);
            sb.append("#");
        }

        return sb.toString().length();
    }
}