package minimum_cost_path_with_alternating_directions_i_3925;

class Solution {
    public int minCost(int m, int n) {
        if(m==1 && n==1) return 1;
        if((m==1 && n==2) || (n==1 && m==2)) return 3;
        return -1;
    }
}