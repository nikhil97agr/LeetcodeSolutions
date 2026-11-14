package minimum_deletion_cost_to_make_all_characters_equal_4138;

class Solution {
    public long minCost(String s, int[] cost) {
        long ans = 0;
        long sum[] = new long[26];
        long total = 0;

        int n = s.length();
        for(int i=0;i<n;i++){
            int ind = s.charAt(i) - 'a';
            sum[ind] += cost[i];
            total += cost[i];
        }
        ans = total;
        for(int i=0;i<26;i++){
            ans = Math.min(ans, total - sum[i]);
        }

        return ans;


    }
}