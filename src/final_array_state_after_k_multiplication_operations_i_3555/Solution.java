package final_array_state_after_k_multiplication_operations_i_3555;

import java.util.*;
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        for(int i=0;i<nums.length;i++){
            que.offer(new int[]{nums[i], i});
        }

        int n = nums.length;
        for(int i=0;i<k;i++){
            int temp[] = que.poll();
            temp[0] = temp[0]*multiplier;
            que.offer(temp);
        }

        int ans[] = new int[n];

        while(!que.isEmpty()){
            int arr[] = que.poll();
            ans[arr[1]] = arr[0];
        }

        return ans;
    }
}