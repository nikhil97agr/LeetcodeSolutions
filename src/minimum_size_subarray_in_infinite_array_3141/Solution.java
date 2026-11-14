package minimum_size_subarray_in_infinite_array_3141;

class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;
        long pre[] = new long[n];
        pre[0] = nums[0];
        for(int i=1;i<n;i++){
            pre[i] = pre[i-1] + nums[i];
        }
        long total = pre[n-1];
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            long s = 0;
            if(i==0){
                s = pre[n-1];
            }else{
                 s= pre[n-1] - pre[i-1];
            }

            if(s >= target){
                int ind = -1;
                int start =i;
                int end = pre.length - 1;
                while(start <= end){
                    int mid = (start + end)/2;

                    long req = pre[mid] - (i == 0 ? 0 : pre[i-1]);
                    if(req > target){
                        end = mid - 1;
                    }else if(req < target){
                        start = mid + 1;
                    }else{
                        ind = mid;
                        end = mid - 1;
                    }
                }

                if(ind != -1){
                    ans = Math.min(ans, ind - i + 1);
                }
                continue;
            }


            int len = n - i;
            long left = target - s;
            long full = left / total;
            len += full*n;
            left = left %total;
            if(left == 0){
                ans = Math.min(ans, len);
                continue;
            }
            int ind = search(pre, left);
            if(ind != -1){
                ans = Math.min(ans, len + ind + 1);
            }
        }

        int len = 0;
            long left = target;
            long full = left / total;
            len += full*n;
            left = left %total;

            int ind = search(pre, left);
            if(ind != -1){
                ans = Math.min(ans, len + ind + 1);
            }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int search(long pre[], long val){
        int start = 0;
        int end = pre.length-1;
        int ind= -1;

        while(start <= end){
            int mid = (start + end)/2;

            if(pre[mid] > val){
                end = mid - 1;
            }else if(pre[mid] < val){
                start = mid + 1;
            }else{
                ind = mid;
                end = mid - 1;
            }
        }

        return ind;
    }
}