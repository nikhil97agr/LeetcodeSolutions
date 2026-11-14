class Solution {
    public int minimumBeautifulSubstrings(String s) {
        Integer dp[][] = new Integer[s.length()][s.length()];
        int ans = solve(0, 0, s.toCharArray(), s.length(), dp);

        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    private int solve(int start, int end, char ch[], int n, Integer dp[][]){
        if(start ==n ){
            return 0;
        }
        if(end == n) return Integer.MAX_VALUE;
        if(dp[start][end] !=null) return dp[start][end];
        int ans = Integer.MAX_VALUE;
        if(check(start, end, ch)){
            int temp = solve(end + 1, end + 1, ch, n, dp);

            if(temp != Integer.MAX_VALUE){
                ans = temp +1;
            }

        }

        int temp = solve(start, end + 1, ch, n, dp);
        if(temp != Integer.MAX_VALUE){
            ans = Math.min(ans, temp );
        }

        return dp[start][end] = ans;
    }

    private boolean check(int start, int end, char ch[]){
        if(ch[start] == '0') return false;
        int num = 0 ;
        int ind = 0;
        while(end >= start){
            if(ch[end] == '1'){
                num |= (1<<ind);
            }
            ind++;
            end--;
        }
        while(num%5==0){
            num/=5;
        }

        return num == 1;
    }
}