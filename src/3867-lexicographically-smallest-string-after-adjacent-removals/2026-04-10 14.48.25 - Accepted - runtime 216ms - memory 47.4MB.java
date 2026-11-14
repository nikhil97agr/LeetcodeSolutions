class Solution {
    public String lexicographicallySmallestString(String s) {
        var n= s.length();
        var remove = new boolean[n][n];
        var ch =s.toCharArray();

        for(int i=0;i+1 <n;i++){
            if(check(ch[i], ch[i+1])){
                remove[i][i+1] = true;
            }
        }

        for(var len = 4;len <= n;len+=2){
            for(int i=0;i+len -1 < n;i++){
                int j = i + len - 1;
                for(int k= i + 1; k <=j;k+=2){
                    if(check(ch[i], ch[k])){
                        var left = k == i + 1 || remove[i+1][k-1];
                        var right = k == j || remove[k+1][j];
                        if(left && right){
                            remove[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        String dp[] = new String[n];
        Arrays.fill(dp, "");

        for(int i= n-1;i>=0;i--){
            dp[i] = ch[i] + (i +1 < n ? dp[i+1] : "");

            for(int j = i +1;j <n;j+=2){
                if(remove[i][j]){
                    if(j +1 == n){
                        dp[i] = "";
                    }else if(dp[j+1].compareTo(dp[i]) < 0){
                        dp[i] = dp[j+1];
                    }
                }
            }
        }

        return dp[0];
    }

    private boolean check(char a, char b){
        int diff= Math.abs(a-b);

        return diff == 1 || diff == 25;
    }
}