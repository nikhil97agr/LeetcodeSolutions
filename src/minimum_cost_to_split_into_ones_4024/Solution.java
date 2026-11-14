package minimum_cost_to_split_into_ones_4024;

class Solution {
    public int minCost(int n) {
        int ans = 0;
        while( n > 1){
            ans += n-1;
            n--;
        }

        return ans;
    }
}