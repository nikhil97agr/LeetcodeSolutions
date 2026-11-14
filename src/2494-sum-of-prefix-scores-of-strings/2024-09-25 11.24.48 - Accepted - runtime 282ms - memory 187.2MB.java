import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sumPrefixScores(new String[]{"abc","ab","bc","b"})));
    }
    public int[] sumPrefixScores(String[] words) {
        int ans[] = new int[words.length];
        Trie trie = new Trie();
        int n = words.length;
        for(String s : words){
            trie.add(s.toCharArray(), 0, s.length());
        }

        for(int i=0;i<n;i++){
            ans[i] = trie.search(words[i].toCharArray(), 0, words[i].length());
        }
        return ans;
    }

    class Trie{
        Trie trie[];
        int cnt;

        public Trie(){
            trie = new Trie[26];
            cnt = 0;
        }

        public void add(char ch[], int i, int n){
            if(i==n){
                return;
            }

            if(trie[ch[i]-'a']==null){
                trie[ch[i]-'a'] = new Trie();
            }
            trie[ch[i]-'a'].cnt++;
            trie[ch[i]-'a'].add(ch, i+1, n);
        }

        public int search(char ch[], int i, int n){
            if(i==n) return cnt;

            return cnt + trie[ch[i]-'a'].search(ch, i+1, n);
        }
    }
}