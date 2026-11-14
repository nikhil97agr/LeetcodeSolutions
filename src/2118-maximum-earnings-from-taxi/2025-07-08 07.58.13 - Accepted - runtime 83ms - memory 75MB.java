class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
       Arrays.sort(rides, (r1, r2) ->{
        if(r1[0] == r2[0]) return r1[1] - r2[1];

        return r1[0] - r2[0];
       });

       Long dp[] = new Long[rides.length];

       return solve(rides.length, rides, 0, dp);
    }

    private long solve(int n, int rides[][],int i, Long dp[]){
        if(i >= n) return 0;

        if(dp[i]!=null) return dp[i];
        int next = search(rides, rides[i][1]);

        return dp[i] = Math.max(
             solve(n, rides, next, dp) + rides[i][1] - rides[i][0] + rides[i][2],
            solve(n, rides, i+1, dp)
        );
    }

    private int search(int rides[][], int val){
        int start = 0;
        int end = rides.length-1;
        int ans = rides.length;

        while(start <= end){
            int mid = (start + end)/2;
            // System.out.println(mid);
            if(rides[mid][0] >= val){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}