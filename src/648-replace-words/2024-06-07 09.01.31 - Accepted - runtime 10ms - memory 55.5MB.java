class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String s : dictionary) trie.add(s, 0 , s.length());
        StringBuilder res = new StringBuilder();
        for(String s : sentence.split(" ")){
            String t = trie.search(s, 0, s.length());
            if(t== null) res.append(s+" ");
            else res.append(t+" ");
        }

        return res.toString().trim();
    }

    class Trie{
        String last;
        Trie trie[];

        public Trie(){
            trie = new Trie[26];
        }

        public void add(String s, int i, int n){
            if(i==n){
                this.last = s;
                return;
            }

            int ind = s.charAt(i)-'a';
            if(trie[ind] == null)  trie[ind] = new Trie();

            trie[ind].add(s, i+1, n);
        }

        public String search(String s, int i, int n){
            if(i==n) return last;
            if(last != null) return last;
            int ind = s.charAt(i)-'a';
            if(trie[ind] == null) return null;

            return trie[ind].search(s, i+1, n);
        }
    }
}