package maximum_compatibility_score_sum_2078;

class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int n = mentors.length;
        Integer dp[][] = new Integer[n][(1<<n)];
        return solve(0, students, mentors, mentors.length, mentors[0].length, 0, dp);
    }

    private int solve(int state, int students[][], int mentors[][], int n, int m, int ind, Integer dp[][]){
        if(ind == n) return 0;
        if(dp[ind][state] !=null) return dp[ind][state];
        int ans = 0;
        for(int i=0;i<n;i++){
            if((state & (1<<i))==0){
                ans = Math.max(ans, getScore(students[i], mentors[ind],m) + solve(state | (1<<i), students, mentors, n, m, ind+1, dp));
            }
        }

        return dp[ind][state] =ans;
    }

    private int getScore(int s1[], int s2[], int m){
        int score = 0;
        for(int i=0;i<m;i++){
            score += 1^(s1[i]^s2[i]);
        }


        return score;
    }
}