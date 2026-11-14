import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        boolean all = true;
        for(int x : nums){
            if(x !=0){
                all = false;
                break;
            }
        }

        if(all) return 0;
        int start = 0, end = m - 1;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            List<List<Integer>> decrements = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                decrements.add(new ArrayList<>());
            }

            for (int i = 0; i <= mid; i++) {
                int s = queries[i][0];
                int e = queries[i][1];
                int val = queries[i][2];

                for (int j = s; j <= e; j++) {
                    decrements.get(j).add(val); 
                }
            }

            boolean possible = true;
            for (int i = 0; i < n; i++) {
                if (!canMakeZero(nums[i], decrements.get(i))) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                ans = mid + 1; 
                end = mid - 1;  
            } else {
                start = mid + 1;  
            }
        }

        return ans; 
    }

    private boolean canMakeZero(int num, List<Integer> list) {
        int n = list.size();
        boolean[] dp = new boolean[num + 1];
        dp[0] = true;  

        for (int i = 0; i < n; i++) {
            int val = list.get(i);
            for (int j = num; j >= val; j--) {
                dp[j] = dp[j] | dp[j-val];
            }
        }

        return dp[num];
    }
}
