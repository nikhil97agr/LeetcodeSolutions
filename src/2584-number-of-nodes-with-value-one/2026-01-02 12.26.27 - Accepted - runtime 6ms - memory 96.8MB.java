class Solution {
    public int numberOfNodes(int n, int[] queries) {
        int flip[] =  new int[n+1];
        for(int q : queries){
            flip[q]++;
        }
        return solve(1, flip, 0, n);
    }

    private int solve(int curr, int flip[], int currFlip, int n){
        if(curr >n ) return 0;

        currFlip += flip[curr];

        return currFlip%2 + solve(2*curr, flip, currFlip, n) + solve(2*curr + 1, flip, currFlip, n);
    }
}