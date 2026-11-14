class Solution {
    public int[] stringIndices(String[] w, String[] q) {
        int n = w.length;
        int ans[] = new int[q.length];
        Trie trie = new Trie();
        for(int i=0;i<n;i++){
            trie.add(w[i], i, w[i].length(), w[i].length()-1);
        }
        
        for(int i=0;i<q.length;i++){
            ans[i] = trie.search(q[i], q[i].length(), q[i].length()-1);
        }
        
        return ans;
    }
    
    class Trie{
        int ind;
        int len;
        Trie[] trie;
        
        public Trie(){
            trie = new Trie[26];
            ind = Integer.MAX_VALUE;
            len = Integer.MAX_VALUE;
        }
        
        public void add(String s, int ind, int n, int i){
            if(n < this.len){
                    this.len = n;
                    this.ind = ind;
            }
            if(i==-1){
                
                return;
            }
            
            Trie trie = this.trie[s.charAt(i)-'a'];
            if(trie == null){
                trie = new Trie();
            }
            this.trie[s.charAt(i)-'a'] = trie;
            trie.add(s, ind, n, i-1);
        }
        public int search(String s, int n, int i){
            if(i == -1) return this.ind;
            
            Trie trie = this.trie[s.charAt(i)-'a'];
            if(trie==null) return this.ind;
            
            return trie.search(s, n,i-1);
        }
    }
}