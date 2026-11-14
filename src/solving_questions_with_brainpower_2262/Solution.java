package solving_questions_with_brainpower_2262;

class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        Long dp[] = new Long[n];

        return solve(0, questions, n, dp);
    }

    private long solve(int i, int questions[][], int n, Long dp[]){
        if(i>=n){
            return 0;
        }

        if(dp[i]!=null){
            return dp[i];
        }

        dp[i] = Math.max(solve(i+questions[i][1]+1, questions, n, dp)+questions[i][0], solve(i+1, questions, n, dp));
        return dp[i];
    }
}