package maximize_score_after_n_operations_1906;

import java.util.*;
class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        System.out.println(n);
        Map<String, Integer> dp = new HashMap<>();
        boolean visited[] = new boolean[n];

        return solve(nums, n, visited, n/2, dp);
    }

    private int solve(int nums[], int n, boolean visited[], int step, Map<String, Integer> dp){
        if(step==0){
            return 0;
        }
        StringBuilder key = new StringBuilder(Arrays.toString(visited));
        key.append(":");
        key.append(step);
        if(dp.containsKey(key.toString())){
            return dp.get(key.toString());
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                for(int j=i+1;j<n;j++){
                    if(!visited[j]){
                        visited[j] = true;
                        ans = Math.max(ans, step*gcd(nums[i], nums[j]) + solve(nums, n, visited, step-1, dp));
                        visited[j] = false;
                    }
                }
                visited[i] = false;
            }
        }

        dp.put(key.toString(), ans);

        return ans;
    }

    private int gcd(int a, int b){
        if(b==0){
            return a;
        }

        return gcd(b, a%b);
    }
}