package construct_string_with_minimum_cost_easy_3480;

class Solution {
    public int minimumCost(String target, String[] words, int[] costs) {
        Integer dp[] = new Integer[target.length()];
        int ans = solve(target, words, 0, target.length(), costs, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int solve(String target, String words[], int i, int n, int costs[], Integer dp[]){
        if(i==n) return 0;

        if(dp[i] !=null) return dp[i];

        int ans = Integer.MAX_VALUE;
        for(int j=0;j<words.length;j++){
            String word = words[j];
            int len = word.length();

            if(len > n - i) continue;
            String sub = target.substring(i, i + len);

            if(sub.equals(word)){
                int temp = solve(target, words, i+len, n, costs, dp);
                if(temp != Integer.MAX_VALUE){
                    ans = Math.min(ans, temp + costs[j]);
                }
            }
        }

        return dp[i] = ans;
    }
}