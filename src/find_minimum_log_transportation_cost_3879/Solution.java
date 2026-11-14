package find_minimum_log_transportation_cost_3879;

class Solution {
    public long minCuttingCost(int n, int m, int k) {
         if(n<= k && m <= k) return 0;
         else if( n <= k){
             return 1l*k*(m-k);
         }else if( m <= k){
             return 1l*k*(n-k);
         }
        return 0;
    }
}