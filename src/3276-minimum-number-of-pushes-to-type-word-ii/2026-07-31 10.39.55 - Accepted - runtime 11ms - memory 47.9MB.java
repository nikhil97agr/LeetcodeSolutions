class Solution {
    public int minimumPushes(String word) {
        Pair pair[] = new Pair[26];
        for(char c = 'a';c<='z';c++){
            pair[c-'a'] = new Pair(c);
        }
        
        for(char c : word.toCharArray()){
            pair[c-'a'].cnt++;
        }
        
        Arrays.sort(pair, (p1,p2)-> p2.cnt - p1.cnt);
        int click = 0;
        int ans = 0;
        int cnt = 0;
        for(Pair p : pair){
            if(cnt%8==0){
                cnt = 0;
                click++;
            }
            if(p.cnt==0) break;
            
            ans += p.cnt*click;
            cnt++;
        }
        return ans;
    }
    
    class Pair{
        char c;
        int cnt;
        public Pair(char c){
            this.c = c;
            this.cnt = 0;
        }
    }
}