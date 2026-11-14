package jump_game_vii_2001;

class Solution {
    public boolean canReach(String s, int min, int max) {
        int n = s.length();
        int cnt[] = new int[n+1];

        int total = 0;
        if(s.charAt(n-1)=='1') return false;
        cnt[min]++;
        cnt[Math.min(n, max+1)]--;

        for(int i=min;i<n;i++){
            total += cnt[i];

            if(total > 0 && s.charAt(i) == '0'){
                if(i+min >= n) continue;

                cnt[i+min]++;
                cnt[Math.min(n, i + max + 1)]--;
            }
        }

        return total > 0;
    }
}