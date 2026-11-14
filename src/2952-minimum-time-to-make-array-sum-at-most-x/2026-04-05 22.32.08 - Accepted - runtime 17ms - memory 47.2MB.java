class Solution {
    public int minimumTime(List<Integer> l1, List<Integer> l2, int x) {
        int n = l1.size();
        int s1 = 0;
        int s2 = 0;
        var pair = new int[n][3];
        for(int i=0;i<n;i++){
            s1 += l1.get(i);
            s2 += l2.get(i);
            pair[i] = new int[]{l1.get(i), l2.get(i), i};
        }
        if(s1 <=x) return 0;
        Arrays.sort(pair, (a,b) -> a[1] - b[1]);

        int dp[] = new int[n + 1];

        int r= n + 1;
        for(int i=1;i<=n;i++){
            for(int j= Math.min(i, r-1);j >0;j--){
                dp[j] = Math.max(dp[j], dp[j-1] + pair[i-1][1] * j + pair[i-1][0]);
                if(s1 + j * s2 - dp[j] <=x){
                    r = j;
                }
            }
        }

        return r <=n ? r : -1;

    }
}