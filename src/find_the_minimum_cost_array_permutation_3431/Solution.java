package find_the_minimum_cost_array_permutation_3431;

class Solution {
    public int[] findPermutation(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];

        Integer score[][][] = new Integer[1<<n][n][n];
        Integer digits[][][] = new Integer[1<<n][n][n];

         int minScore = solve(1, 0, 0, score, digits, n, nums);
         int start = 0;
            int state = 1;
            int next = 0;
            for(int i=0;i<n;i++){
                res[i]= next;

                next = digits[state][start][next];
                state |= (1<<next);
            }
        return res;
    }

    private int solve(int state, int first, int last, Integer[][][] score, Integer[][][] digits, int n, int[] nums) {
        if(score[state][first][last] != null) return score[state][first][last];

        if( state == ((1<<n)-1)){
            digits[state][first][last] = last;
            return Math.abs(last - nums[first]);
        }

        int currScore = Integer.MAX_VALUE;
        int currDigit = 0;
        for(int i=0;i<n;i++){
            if( (state & (1<<i)) == 0){
                int newState = state | (1<<i);
                int curr = Math.abs(last - nums[i]) + solve(newState, first, i, score, digits, n, nums);
                if(curr < currScore){
                    currDigit = i;
                    currScore = curr;
                }
            }
        }

        digits[state][first][last] = currDigit;
        return score[state][first][last] = currScore;
    }
}