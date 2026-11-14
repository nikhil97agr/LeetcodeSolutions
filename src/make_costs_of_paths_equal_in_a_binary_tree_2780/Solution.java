package make_costs_of_paths_equal_in_a_binary_tree_2780;

class Solution {
    public int minIncrements(int n, int[] cost) {
        return dfs(1, cost, n)[0];
    }

    private int[] dfs(int curr, int cost[], int n){
        if(curr > n) return new int[]{0, 0};

        int left[] = dfs(2*curr ,cost, n);
        int right[] = dfs(2*curr + 1, cost, n);

        int s1 = left[1];
        int s2 = right[1];

        int step = Math.max(s1, s2) - Math.min(s1 , s2);

        return new int[]{left[0] + right[0] + step, Math.max(s1, s2) + cost[curr-1]};
    }
}