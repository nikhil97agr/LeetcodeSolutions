class Solution {
    public int numberOfSubstrings(String s, int k) {
        int ans = 0;
        
        int cnt[] = new int[26];
        int i=0;
        int j=0;
        int n = s.length();
        while(j < s.length()){
            char c = s.charAt(j);
            cnt[c-'a']++;
            
            while(isPossible(cnt, k)){
                ans += (n-j);
                cnt[s.charAt(i)-'a']--;
                i++;
            }
        j++;
            
        }
        
        while(isPossible(cnt, k)){
            ans++;
            cnt[s.charAt(i)-'a']--;
            i++;
        }
        return ans;
    }
    
    private boolean isPossible(int cnt[], int k){
        int max = 0;
        
        for(int x : cnt) max = Math.max(max, x);
        
        return max >= k;
    }
}