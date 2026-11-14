package count_frequency_staircase_subarrays_i_4441;

import java.util.*;
class Solution {
    public int countStaircase(int[] nums) {
        int ans = 0;
        int n= nums.length;
        for(int i=0;i<n;i++){
            Map<Integer, Integer> cnt= new HashMap<>();
            Map<Integer, Integer> seq = new HashMap<>();

            int dist = 0;
            int complete = 0;
            int next = 1;
            for(int j=i;j<n;j++){
                int val = nums[j];
                int prev = cnt.getOrDefault(val, 0);
                if(prev== 0){
                    seq.put(val, next++);
                    dist++;
                }

                cnt.merge(val, 1, Integer::sum);

                if(cnt.get(val) > seq.get(val)){
                    break;
                }

                if(cnt.get(val) == seq.get(val)){
                    complete++;

                }

                if(dist == complete){
                    ans++;
                }
            }

        }
        return ans;
    }
}