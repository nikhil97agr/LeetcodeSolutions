class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(String word : words){
            trie.add(word, 0, word.length());
        }
        return trie.search();
    }

    class Trie{
        boolean isLast;
        Trie trie[];
        
        public Trie(){
            this.isLast = false;

            trie  = new Trie[26];
        }

        public void add(String s, int i, int n){
            if(i==n){
                this.isLast = true;
                return;
            }
            int ind = s.charAt(i) - 'a';
            if(trie[ind] == null) trie[ind] = new Trie();
            trie[ind].add(s, i+1, n);
        }

        public String search(){
            String res = "";
            for(char c = 'a'; c<='z';c++){
                if(trie[c-'a']!=null && trie[c-'a'].isLast){
                    String temp = ""+c+trie[c-'a'].search();
                    if(res.length() < temp.length()){
                        res = temp;
                    }else if(res.length() == temp.length() && res.compareTo(temp) > 0){
                        res = temp;
                    }
                }
            }
            return res;
        }
    }
}