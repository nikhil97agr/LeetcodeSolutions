class Solution {
    public int minDeletion(String s, int k) {
        int cnt[] = new int[26];
        for(char c : s.toCharArray()) cnt[c-'a']++;

        int dist = 0;
        for(int x : cnt){
            if(x > 0) dist++;
        }

        Arrays.sort(cnt);
        int ans = 0;
        for(int i=0;i<26;i++){
            if(dist <= k) break;
            if(cnt[i] == 0) continue;
            ans += cnt[i];
            dist--;
        }

        return ans;
    }
}