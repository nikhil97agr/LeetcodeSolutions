package subarray_product_less_than_k_713;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0){
            return 0;
        }

        int total = 1;
        int start = 0;
        int end = 0;
        int count = 0;
        int n = nums.length;
        while(end <n){
            if(total*nums[end]<k){
                total *=nums[end];
                end++;
                continue;
            }

            while(start<end && total*nums[end]>=k){
                count += (end-start);
                total/=nums[start];
                start++;
            }
            if(start==end){
                if(nums[end]>=k){
                    start++;
                    end++;
                    continue;
                }
            }
            total*=nums[end];
            end++;
        }

        while(start<n){
            count += (end-start);
            start++;
        }
        return count;
    }
}