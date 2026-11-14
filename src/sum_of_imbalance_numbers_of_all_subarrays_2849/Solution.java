package sum_of_imbalance_numbers_of_all_subarrays_2849;

import java.util.*;
class Solution {
    public int sumImbalanceNumbers(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int imbalance = 0;
            List<Integer> list = new ArrayList<>();
            for(int j=i;j<n;j++){
                int ind = Collections.binarySearch(list, nums[j]);
                if(ind < 0){
                    ind = -ind - 1;
                }

                if(ind != list.size() && ind != 0){
                    if(list.get(ind) - list.get(ind-1) > 1) imbalance--;

                }

                if(ind == list.size()) list.add(nums[j]);
                else list.add(ind, nums[j]);

                if(ind !=0){
                    if(list.get(ind) - list.get(ind-1) > 1) imbalance++;
                }

                if(ind != list.size() - 1){
                    if(list.get(ind+1) - list.get(ind) > 1) imbalance++;
                }

                ans += imbalance;


            }
        }

        return ans;
    }
}