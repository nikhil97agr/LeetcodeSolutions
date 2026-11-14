package words_within_two_edits_of_dictionary_2550;

import java.util.*;
class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        Trie trie= new Trie();
        for(String s : dictionary){
            trie.insert(s.toCharArray(), s.length(), 0);
        }
        var result = new ArrayList<String>();

        for(String s : queries){
            if(trie.search(s.toCharArray(), s.length(), 0,0)){
                result.add(s);
            }
        }

        return result;
    }

    class Trie{
        Trie node[];
        int cnt;
        public Trie(){
            node = new Trie[26];
            cnt = 0;
        }

        public void insert(char ch[], int n, int i){
            if(i==n){

                cnt++;
                return ;
            }

            int ind = ch[i] - 'a';
            if(node[ind]== null) node[ind] = new Trie();
            node[ind].insert(ch, n, i+1);
            
        }

        public boolean search(char ch[], int n, int i, int change){
            if(i== n){
                return cnt > 0;
            }

            if(change < 2){
                for(char c ='a';c<='z';c++){
                    int ind = c-'a';
                    if(node[ind] ==null) continue;

                    if(c == ch[i]){
                        boolean ans = node[ind].search(ch, n, i+1, change);
                        if(ans) return true;
                    }else{
                        boolean ans = node[ind].search(ch, n, i+1, change + 1);
                        if(ans) return true;
                    }
                }
            }else{
                int ind = ch[i] - 'a';
                if(node[ind] !=null){
                    boolean ans = node[ind].search(ch, n, i+1, change);
                    if(ans) return true;
                }
            }

             return false;
        }
    }
}