package strings_differ_by_one_character_1697;

class Solution {
    public boolean differByOne(String[] dict) {
        Trie trie= new Trie();
        for(String s : dict){
            trie.add(s.toCharArray(), 0, s.length());
        }
        
        for(String s : dict){
            if(trie.search(s.toCharArray(), 0, s.length(), 0)) return true;
        }
        
        return false;
    }

    class Trie{
        boolean isWord;
        Trie trie[];

        public Trie(){
            isWord = false;
            trie =new Trie[26];
        }

        public boolean search(char ch[], int i, int n, int cnt){
            if(cnt > 1) return false;
            if(cnt == 1 && i ==n ) return isWord;
            if(i==n) return false;
            
            for(char c = 'a';c<='z';c++){
                int ind = (c-'a');
                
                if(trie[ind] == null) continue;
                if(ch[i] == c){
                    if(trie[ind].search(ch, i+1, n, cnt)) return true;
                }else{
                    if(trie[ind].search(ch, i+1, n,cnt+1)) return true;
                }
            }
            
            return false;
        }

        public void add(char ch[], int i, int n){
            if(i==n){
                isWord = true;
                return;
            }

            int ind = ch[i] - 'a';
            if(trie[ind] ==null){
                trie[ind] = new Trie();
            }

            trie[ind].add(ch, i+1, n);
        }
    }
}