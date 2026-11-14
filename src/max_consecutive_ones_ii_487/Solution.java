package max_consecutive_ones_ii_487;

import java.util.*;
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        List<int[]> list = new ArrayList<>();
        int start = -1;
        int end = -1;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                if(start != -1){
                    list.add(new int[]{start, end});
                    start = end = -1;
                }
            }else{
                if(start == -1){
                    start = i;
                }

                end = i;
            }
        }

        if(start != -1){
            list.add(new int[]{start, end});
        }

        if(list.isEmpty()) return 1;

        int size = list.size();
        int ans = 0;
        for(int i[] : list){
            ans = Math.max(ans, end - start + 1);
        }

        for(int i=0;i<size;i++){
                int curr[] = list.get(i);

            if(i < size - 1){
                int next[] = list.get(i+1);
                if(next[0] - curr[1] == 2){
                    ans = Math.max(ans, curr[1] - curr[0] + next[1] - next[0] + 3);
                }
            }

            if(curr[0] > 0 || curr[1] < n-1){
                ans = Math.max(ans, curr[1] - curr[0] + 2);
            }


        }

        return ans;
    }
}