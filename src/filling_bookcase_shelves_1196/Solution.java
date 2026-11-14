package filling_bookcase_shelves_1196;

class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        Integer dp[][] = new Integer[books.length][shelfWidth+1];
        return solve(books, 0, books.length, shelfWidth, 0, 0, dp);
    }

    private int solve(int books[][], int i, int n, int shelfWidth, int currMax, int width, Integer dp[][]){

        if(i==n) return currMax;

        if(dp[i][width]!=null) return dp[i][width];

        if(i==0){
            return solve(books, i+1, n, shelfWidth, books[i][1], books[i][0], dp);
        }  
        int ans = Integer.MAX_VALUE;
        if(width + books[i][0]<= shelfWidth){
            ans = solve(books, i+1, n, shelfWidth , Math.max(currMax, books[i][1]), width  +books[i][0], dp);
        }

        ans = Math.min(ans, solve(books, i+1, n, shelfWidth, books[i][1], books[i][0], dp)+currMax);
        return dp[i][width] = ans;
    }


}