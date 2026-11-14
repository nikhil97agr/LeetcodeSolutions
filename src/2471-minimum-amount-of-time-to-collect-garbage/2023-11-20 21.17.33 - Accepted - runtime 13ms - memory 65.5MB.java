class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int cnt[] = new int[26];
        int ind[] = new int[26];
        int n = travel.length;
        int prefix[] = new int[n+1];
        for(int i=0;i<n;i++){
            prefix[i+1] = prefix[i] + travel[i];
        }
        for(int i=0;i<garbage.length;i++){
            for(char c : garbage[i].toCharArray()){
                ind[c-'A'] = i;
                cnt[c-'A']++;
            }
        }
        char chars[] = new char[]{'G','P','M'};
        int ans = 0;
        for(char c : chars){
            ans += prefix[ind[c-'A']] + cnt[c-'A'];
        }
        return ans;
    }
}