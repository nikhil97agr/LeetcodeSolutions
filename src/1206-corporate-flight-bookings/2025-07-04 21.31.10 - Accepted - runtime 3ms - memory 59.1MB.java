class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int ans[] = new int[n];

        int sum[] = new int[n+2];
        for(int b[] : bookings){
            int start = b[0];
            int end = b[1];
            int seat = b[2];

            sum[start]+= seat;
            sum[end+1]-= seat;
        }

        int total = 0;
        for(int i=1;i<=n;i++){
            total += sum[i];
            ans[i-1] =total;
        }

        return ans;
    }
}