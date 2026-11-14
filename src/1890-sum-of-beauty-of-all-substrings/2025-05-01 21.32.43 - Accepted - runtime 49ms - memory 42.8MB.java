class Solution {
    public int beautySum(String s) {
        int ans = 0;
        int n = s.length();

        for(int i=0;i<n;i++){
            int cnt[] = new int[26];
            int max = 0;
            for(int j=i;j<n;j++){
                char c = s.charAt(j);
                cnt[c-'a']++;
                max = Math.max(max, cnt[c-'a']);

                int min = Integer.MAX_VALUE;
                for(int x : cnt){
                    if(x!=0) min = Math.min(min, x);
                }
                ans += (max - min);
            }
        }
        return ans;
    }
}