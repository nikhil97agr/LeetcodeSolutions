class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        trie.isLast = true;
        String result = "";
        for(String s : words){
            trie.add(s.toCharArray(), 0, s.length());
        }

        for(String s : words){
            int ans = trie.find(s.toCharArray(), 0, s.length())-1;
            if(ans == s.length() ){
                if(s.length() > result.length()) result= s;
                else if(s.length() == result.length() && s.compareTo(result) < 0) result = s;
            }
        }

        return result;
    }

    class Trie{
        Trie trie[];
        boolean isLast;
        public Trie(){
            this.trie = new Trie[26];
        }

        public void add(char ch[], int i, int n){
            if(i==n) {
                isLast = true;
                return;
            }
            


            Trie node = trie[ch[i]-'a'];
            if(node == null){
                trie[ch[i]-'a'] = new Trie();
                node = trie[ch[i]-'a'];
            }

            node.add(ch, i+1, n);
        }

        private int find(char ch[], int i, int n){
            if(!isLast) return 0;
            if(i==n){
                return 1;
            }


            Trie node= trie[ch[i]-'a'];

            if(node ==null) return 0;

            return 1 + node.find(ch,i+1, n);
        
        }
    }
}