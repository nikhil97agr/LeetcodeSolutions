class WordDictionary {
    
    class Trie{
        Trie[] tries;
        boolean isLast;
        
        public Trie(){
            this.tries = new Trie[26];
            isLast = false;
        }
        
        public void construct(String s, int n, int i){
            if(i==n){
                isLast = true;
                return;
            }
            int ind = s.charAt(i)-'a';
            Trie temp = tries[ind];
            if(temp==null){
                temp  = new Trie();
                tries[ind]  =temp;
            }
            
            temp.construct(s, n, i+1);
        }
        
        public boolean search(String s, int n, int i){
            if(i==n){
                return isLast;
            }
            if(s.charAt(i)=='.'){
                for(Trie trie : tries){
                    if(trie!=null){
                        if(trie.search(s, n, i+1)){
                            return true;
                        }
                    }
                }
                return false;
            }
            int ind = s.charAt(i)-'a';
             if(tries[ind]!=null){
                return tries[ind].search(s, n, i+1);
            }
            return false;
        }
        
    }
    
    Trie trie;
    public WordDictionary() {
        trie = new Trie();
        
    }
    
    public void addWord(String word) {
        trie.construct(word, word.length(), 0);
    }
    
    public boolean search(String word) {
        return trie.search(word, word.length(), 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */