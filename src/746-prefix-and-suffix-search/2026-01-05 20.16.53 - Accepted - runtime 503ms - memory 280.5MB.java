class WordFilter {
    Trie trie;
    public WordFilter(String[] words) {
        trie = new Trie();
        for(int i=0;i<words.length;i++){
            int n = words[i].length();
            String s= words[i];
            for(int j=0;j<n;j++){
                String w = s.substring(j)+":"+s;
            trie.add(0, i, w.length(), w.toCharArray());
            }
        }
    }
    
    public int f(String pref, String suff) {
        String w = suff+":"+pref;
        return trie.search(0, w.length(), w.toCharArray());
    }

    class Trie{
        Map<Character, Trie> map =new HashMap<>();
        int ind = -1;
        public Trie(){
            map =new HashMap<>();
        }
        public int search(int i, int n, char ch[]){
            if(i==n) return ind;   

            if(!map.containsKey(ch[i])) return -1;

            return map.get(ch[i]).search(i+1, n, ch);
        }
        public void add(int i, int ind, int n, char ch[]){
            this.ind = Math.max(this.ind , ind);
            if(i==n) return;
            map.putIfAbsent(ch[i], new Trie());
            map.get(ch[i]).add(i+1,ind,n, ch);
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */