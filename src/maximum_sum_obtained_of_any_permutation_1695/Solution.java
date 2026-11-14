package maximum_sum_obtained_of_any_permutation_1695;

import java.util.*;
class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int cnt[] =new int[n+1];

        for(int r[] : requests){
            int start = r[0];
            int end = r[1];

            cnt[start]++;
            cnt[end+1]--;
        }

        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        int sum =0;
        for(int i=0;i<n;i++){
            sum += cnt[i];
            que.offer(sum);
        }

        Arrays.sort(nums);
        int ans = 0;

        for(int i=n-1;i>=0;i--){
            ans = sum(ans, 1l*que.poll() * nums[i]);
        }

        return ans;


    }

    int sum(int a, long b){
        int mod = (int)1e9+ 7;

        return(int) ((1l*a +b)%mod);
    }
}