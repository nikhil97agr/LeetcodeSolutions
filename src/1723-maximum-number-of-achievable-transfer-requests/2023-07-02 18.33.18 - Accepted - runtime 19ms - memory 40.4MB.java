class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int count[] = new int[n];
        return solve(count, n, requests, 0, 0);
        
    }

    private int solve(int cnt[], int n, int [][] req, int i, int total){
        if(req.length==i){
            for(int j=0;j<n;j++){
                if(cnt[j]!=0) return 0;
            }
            return total;
        }

        cnt[req[i][0]]--;
        cnt[req[i][1]]++;
        int a = solve(cnt, n, req, i+1, total+1);
        cnt[req[i][0]]++;
        cnt[req[i][1]]--;
        int b = solve(cnt, n, req, i+1, total);
        return Math.max(a,b);
    }
}