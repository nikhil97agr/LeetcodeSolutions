package implement_trie_ii_prefix_tree_1949;

class Trie {
    Trie nodes[];
    int cnt = 0;
    int end = 0;
    public Trie() {
        nodes = new Trie[26];
    }
    
    public void insert(String word) {
        insert(word, 0, word.length());
    }

    private void insert(String word, int i, int n){
        this.cnt++;
        if(i==n){
            this.end++;
            return ;
        }
        int ind = word.charAt(i) - 'a';
        if(nodes[ind]==null){
            nodes[ind] = new Trie();
        }

        nodes[ind].insert(word, i+1, n);
    }
    
    public int countWordsEqualTo(String word) {
        return count(word, 0, word.length());
    }

    private int count(String word, int i, int n){
        if(i==n) return this.end;

        int ind = word.charAt(i) - 'a';

        if(nodes[ind]==null){
            return 0;
        }

        return nodes[ind].count(word, i+1, n);
    }
    
    public int countWordsStartingWith(String prefix) {
        return countPrefix(prefix, 0, prefix.length());
    }

    public int countPrefix(String word, int i, int n){
        if(i==n) return this.cnt;

        int ind = word.charAt(i) - 'a';

        if(nodes[ind] ==null) return 0;

        return nodes[ind].countPrefix(word, i+1, n);
    }
    
    public void erase(String word) {
        erase(word, 0, word.length());
    }

    private void erase(String word, int i, int n){
        this.cnt--;
        if(i==n){
            this.end--;
            return;
        }

        int ind = word.charAt(i) - 'a';
        nodes[ind].erase(word, i+1, n);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */