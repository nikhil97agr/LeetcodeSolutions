package number_of_distinct_substrings_in_a_string_1838;

class Solution {
    public int countDistinct(String s) {
        int ans= 0;
        int n = s.length();
        Trie trie = new Trie();
        for(int i=0;i<n;i++){
            Trie curr = trie;
            int j=i;
            while(j < s.length() && curr.find(s.charAt(j))!=null){
                curr = curr.find(s.charAt(j));
                j++;
            }

            while( j < s.length()){
                curr = curr.add(s.charAt(j));
                ans++;
                j++;
            }
        }
        return ans;
    }

    class Trie{
        Trie trie[];
        public Trie(){
            trie = new Trie[26];
        }

        private Trie find(char c){
            int ind = c-'a';
            if(trie[ind] == null) return null;
            return trie[ind];
        }

        private Trie add(char c){
            int ind = c- 'a';
            trie[ind] = new Trie();
            return trie[ind];
        }




    }
}