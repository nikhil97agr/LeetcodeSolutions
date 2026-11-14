package count_the_number_of_k_free_subsets_2738;

import java.util.*;
class Solution {
    public long countTheNumOfKFreeSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int x : nums){
            int rem = x%k;
            map.computeIfAbsent(rem, y -> new ArrayList<>()).add(x);
        }
        long ans = 1;
        for(List<Integer> list : map.values()){
            int len = list.size();
            long dp[] = new long[len + 1];
            dp[0] = 1;
            dp[1] = 2;

            for(int i=1;i<len;i++){
                if(list.get(i) - list.get(i-1) == k){
                    dp[i+1] = dp[i] + dp[i-1];
                }else{
                    dp[i+1] = (dp[i] << 1);
                }
            }

            ans *= dp[len];
        }
        return ans;
    }

    


}