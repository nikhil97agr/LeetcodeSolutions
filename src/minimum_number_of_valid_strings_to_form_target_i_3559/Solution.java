package minimum_number_of_valid_strings_to_form_target_i_3559;

import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public int minValidStrings(String[] words, String target) {
        Trie trie = new Trie(words);
        int n = target.length();
        int dp[] = new int[n+1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        for(int i=n-1;i>=0;i--){
            Trie curr = trie;
            for(int j=i;j<n;j++){
                Trie next = curr.trie[target.charAt(j) - 'a'];
                if(next == null) break;
                curr = next;
                if(dp[j+1] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1 + dp[j+1]);
            }
        }
        


        return dp[0] != Integer.MAX_VALUE ? dp[0] : -1;


    }


    
    class State{
        Trie trie;
        int ind;
        public State(Trie trie, int ind){
            this.trie = trie;
            this.ind = ind;
        }
    }

    class Trie{
        Trie[] trie;

        public Trie(String s[]){
            trie = new Trie[26];

            for(String st: s){
                add(st, 0, st.length());
            }

        }

        public Trie(){
            trie = new Trie[26];
        }

        private void add(String s, int i, int n){
            if(i==n) return;

            int ind = s.charAt(i) - 'a';

            if(trie[ind] == null) trie[ind] = new Trie();

            trie[ind].add(s, i +1 ,n);

        }

        @Override
        public boolean equals(Object o) {

            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Trie trie1 = (Trie) o;
            return Objects.deepEquals(trie, trie1.trie);
        }

        @Override
        public int hashCode() {

            return Arrays.hashCode(trie);
        }
    }
}