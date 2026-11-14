package word_squares_425;

import java.util.*;
class Solution {
    public List<List<String>> wordSquares(String[] words) {
        Trie trie = new Trie();
        for(String s : words) trie.add(s.toCharArray(), 0, s.length());
        int n = words[0].length();
        List<List<String>> result = new ArrayList<>();
        for(String word : words){
            List<String> list = new ArrayList<>();
            list.add(word);
            solve(result, list, n, trie, 1);

        }

        return result;
    }

    private void solve(List<List<String>> result, List<String> list, int n, Trie trie, int ind){
        if(ind == n){
            result.add(new ArrayList<>(list));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(String s : list){
            sb.append(s.charAt(ind));
        }

        for(String s : trie.check(sb.toString().toCharArray(), 0, sb.length())){
            list.add(s);
            solve(result, list, n, trie, ind +1);
            list.remove(list.size() - 1);
        }
    }



    class Trie{
        Trie trie[];
        List<String> list= new ArrayList<>();
        public Trie(){
            trie = new Trie[26];
        }

        public List<String> check(char ch[], int i, int n){

            if(i==n) return list;

            int ind = ch[i] - 'a';
            if(trie[ind] ==null) return new ArrayList<>();
            return trie[ind].check(ch, i+1, n);
        }

        public void add(char ch[], int i, int n){
                        if(i!=0){
                list.add(new String(ch));
            }
            if(i==n) return;
            int ind = ch[i] - 'a';

            if(trie[ind]==null){
                trie[ind] = new Trie();
            }

            trie[ind].add(ch, i+1, n);

        }
    }
}