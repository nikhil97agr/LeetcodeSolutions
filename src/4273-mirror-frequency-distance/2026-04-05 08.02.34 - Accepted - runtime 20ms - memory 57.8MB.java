class Solution {
    public int mirrorFrequency(String s) {
        int cnt[] = new int[256];
        for(char c : s.toCharArray()){
            cnt[c]++;
        }
        int ans = 0;

        for(char start = 'a',end='z';start<end;start++,end--){
            ans += Math.abs(cnt[start] - cnt[end]);
        }

        for(char start='0',end='9';start<end;start++,end--){
            ans += Math.abs(cnt[start] - cnt[end]);
        }

        return ans;
    }
}