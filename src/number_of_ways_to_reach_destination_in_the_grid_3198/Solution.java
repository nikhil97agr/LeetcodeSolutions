package number_of_ways_to_reach_destination_in_the_grid_3198;

class Solution {

    int n;
    int m;
    long mod = (long) 1e9 + 7;
    Integer dp[][][];

    public int numberOfWays(int n, int m, int k, int[] source, int[] dest) {
        this.n = n;
        this.m = m;
        dp = new Integer[2][2][k+1];
        return solve(
                source[0] == dest[0] ? 1 : 0,
                source[1] == dest[1] ? 1 : 0,
                k
        );
    }

    private int solve(int sameRow, int sameColumn, int k) {
        if(dp[sameRow][sameColumn][k] != null) return dp[sameRow][sameColumn][k];
        if (k > 1) {
            int rowMove = 0;
            int colMove = 0;
            if (sameRow == 1) {
                rowMove = prod(n-1, solve(0, sameColumn, k-1));
            } else {
                rowMove = add(solve(1, sameColumn, k-1), prod(n-2, solve(0, sameColumn, k-1)));
            }

            if (sameColumn == 1) {
                colMove = prod(m-1, solve(sameRow, 0, k-1));
            } else {
                colMove = add(solve(sameRow, 1, k-1), prod(m-2, solve(sameRow, 0, k-1)));
            }

            return dp[sameRow][sameColumn][k] = add(rowMove, colMove);
        } else {
            if ((sameRow == 1 && sameColumn == 0) || (sameRow == 0 && sameColumn == 1)) {
                return 1;
            }

            return 0;
        }
    }

    private int add(long a, long b) {

        return (int) ((a % mod + b % mod) % mod);
    }

    private int prod(long a, long b) {

        return (int) ((a % mod * b % mod) % mod);
    }
}