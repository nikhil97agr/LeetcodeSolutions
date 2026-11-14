package word_search_ii_212;

import java.util.*;
class Solution {

    class Trie{
        Trie trie[];
        String word;

        public Trie(){
            trie = new Trie[26];
            word = null;
        }
        public void construct(String word, int i, int n){
            if(i==n){
                this.word = word;
                return;
            }
            char ch = word.charAt(i);
            if(trie[ch-'a']==null){
                trie[ch-'a'] = new Trie();
            }

            trie[ch-'a'].construct(word, i+1, n);
        }

        public void check(char board[][], int i, int j, int n, int m, Set<String> result){
            if(this.word!=null){
                result.add(word);
            }

            if(i<0||j<0||i>=n||j>=m||board[i][j]=='$'){
                return;
            }
            char ch  = board[i][j];
            if(trie[ch-'a']==null){
                return;
            }
            board[i][j] = '$';
            trie[ch-'a'].check(board, i+1, j, n, m, result);
            trie[ch-'a'].check(board, i-1, j, n, m, result);
            trie[ch-'a'].check(board, i, j+1, n, m, result);
            trie[ch-'a'].check(board, i, j-1, n, m, result);
            board[i][j] = ch;

        }


    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words){
            
            trie.construct(word, 0, word.length());
        }
        int n = board.length;
        int m = board[0].length;
        
        Set<String> result = new HashSet<String>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                trie.check(board, i, j,n,m, result);
            }
        }
        return new ArrayList(result);
    }
}