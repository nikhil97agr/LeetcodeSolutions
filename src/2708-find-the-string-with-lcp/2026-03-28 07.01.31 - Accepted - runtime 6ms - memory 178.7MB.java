class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char res[] = new char[n];
        res[0] = 'a';
        char next = 'b';
        for(int i=1;i<n;i++){
            boolean found = false;
            for(int j=0;j<i;j++){

                if(lcp[j][i]  !=0){
                    res[i] = res[j];
                    found = true;
                }
            }

            if(!found){
                if(next <= 'z'){
                    res[i] = next;
                    next++;
                }else{
                    return "";
                }
            }
        }

        int dp[][]= new int[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(res[i] == res[j]){
                    dp[i][j] = (i ==n-1 || j == n-1) ? 1 : (1 + dp[i+1][j+1]);
                }
            }
        }

        for(int i=0;i<n;i++){
            if(!Arrays.equals(dp[i], lcp[i])){
                return "";
            }
        }

        return new String(res);
    }
}