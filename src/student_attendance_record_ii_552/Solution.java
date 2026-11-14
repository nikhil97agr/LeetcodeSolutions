package student_attendance_record_ii_552;

class Solution {
    long mod = (long)1e9+7;
    public int checkRecord(int n) {
        Long dp[][][] = new Long[n][3][2];
        return (int)solve(0, 0, n, 0, dp);
    }

    private long solve(int lateCount, int absentCount, int n , int i, Long dp[][][]){
        if(absentCount>=2) return 0;
        if(lateCount>=3) return 0;
        if(i==n) return 1;

        if(dp[i][lateCount][absentCount]!=null) return dp[i][lateCount][absentCount];
        if(lateCount==2) return dp[i][lateCount][absentCount] =  (solve(0, absentCount+1, n, i+1, dp)%mod + solve(0, absentCount, n, i+1, dp)%mod)%mod;

        if(absentCount==1) return dp[i][lateCount][absentCount] = (solve(lateCount+1, absentCount, n, i+1, dp)%mod + solve(0, absentCount, n, i+1,dp)%mod)%mod;

        return dp[i][lateCount][absentCount] = (solve(lateCount+1, absentCount, n,i+1, dp)%mod + solve(0, absentCount+1, n, i+1, dp)%mod + solve(0, absentCount, n, i+1, dp)%mod)%mod;
    }
}