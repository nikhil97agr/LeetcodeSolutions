class Solution {
    public long minimumCost(String source, String target, char[] c1, char[] c2, int[] cost) {
        long ans = 0;
        int n = c1.length;
        int m = source.length();

        long dist[][] = new long[26][26];
        for(long d[] : dist){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){

            dist[c1[i]-'a'][c2[i]-'a'] = Math.min(dist[c1[i]-'a'][c2[i]-'a'], cost[i]);
        }

        for(int i=0;i<26;i++) dist[i][i] = 0;

        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

                }
            }
        }

        for(int i=0;i<m;i++){
            char ch1 = source.charAt(i);
            char ch2 = target.charAt(i);
            if(dist[ch1-'a'][ch2-'a']==Integer.MAX_VALUE) return -1;
            ans += dist[ch1-'a'][ch2-'a'];
        }

        return ans;
    }
}