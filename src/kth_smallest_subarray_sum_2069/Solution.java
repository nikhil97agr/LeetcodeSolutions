package kth_smallest_subarray_sum_2069;

class Solution {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int pre[] = new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1] = pre[i] + nums[i];
        }

        int ans = -1;
        int min = 0;
        int max = pre[n];
        while(min <= max){
            int mid = min + (max-min)/2;
            int cnt = 0;
            for(int i=0;i<n;i++){
                cnt += search(pre, mid, i+1);
            }

            if(cnt < k){
                min = mid + 1;
            }else{
                max = mid - 1;
                ans = mid;
            }
        }

        return ans;
    }

    private int search(int pre[], int val, int start){
        int s = start;
        int end = pre.length - 1;
        int total = 0;
        while(start <= end){
            int mid = (start + end)/2;
            if(pre[mid] - pre[s-1] > val){
                end = mid - 1;
            }else{
                total = mid - s + 1;
                start = mid + 1;
            }
            
        }

        return total;
    }
}