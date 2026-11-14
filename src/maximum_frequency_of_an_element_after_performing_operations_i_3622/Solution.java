package maximum_frequency_of_an_element_after_performing_operations_i_3622;

import java.util.*;
class Solution {
    public int maxFrequency(int[] nums, int k, int op) {
        int ans = 0;
        Map<Integer, Integer> map =new HashMap<>();
        Arrays.sort(nums);
        for(int x : nums){
             map.merge(x, 1, Integer::sum);
        }
        int n = nums.length;
        for(int i=nums[0];i<=nums[n-1];i++){
            int left = left(nums, i, 0, n-1,k);
            int right = right(nums, i, 0, n-1,k);
            if(left <= right){
                int cnt = right - left + 1;
                int c = map.getOrDefault(i, 0);
                int remain = cnt - c;
                ans = Math.max(ans, c + Math.min(op, remain));
            }
        }

        return ans;
    }

    private int left(int nums[], int val, int start, int end,int k){
        int ind = end;
        while(start <= end){
            int mid = (start + end)/2;

            if(nums[mid] > val){
                end = mid - 1;
            }else{
                int diff = val - nums[mid];

                if(diff <= k){
                    ind = mid;
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            }
        }

        return ind;
    }

    private int right(int nums[], int val, int start, int end, int k ){
        int ind = 0;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] < val){
                start = mid + 1;
                
            }else{
                int diff = nums[mid] - val;
                if(diff <= k){
                    ind = mid;
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }

        return ind;
    }
}