package find_the_shortest_superstring_980;

class Solution {
    public String shortestSuperstring(String[] words) {
        int n = words.length;

        if(n==1) return words[0];
        int cost[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    cost[i][j] = calcCost(words[i], words[j]);
                }
            }
        }
        String result = "";
        int len = Integer.MAX_VALUE;
        int mask = (1<<n);
        String dp[][] = new String[mask][n];
        for(int i=0;i<n;i++){
            String s = words[i]+solve(words, cost, dp, 1<<i, i,n);
            if(s.length() < len){
                len = s.length();
                result = s;
            }
        }

        return result;
        
    }

    private String solve(String words[], int cost[][], String dp[][], int mask, int i, int n){
        if(mask == (1<<n)-1) return "";

        if(dp[mask][i]!=null) return dp[mask][i];
        int len = Integer.MAX_VALUE;
        String ans = "";
        for(int j=0;j<n;j++){
            if((mask &(1<<j))==0){
                String s = words[j].substring(words[j].length()-cost[i][j]) + solve(words, cost, dp, mask |(1<<j), j, n);
                if(s.length()< len){
                    ans = s;
                    len = s.length();
                }
            }
        }
        return dp[mask][i] = ans;
    }

    private int calcCost(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        for(int i=0;i<n;i++){
            if(s2.startsWith(s1.substring(i))){
                return m - n +i;
            }
        }

        return m;
    }
}