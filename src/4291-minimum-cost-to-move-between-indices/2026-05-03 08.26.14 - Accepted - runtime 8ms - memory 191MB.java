class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;
        int close[] = new int[n];
        for(int i=0;i<n;i++){
            int ind = n + 1;
            int diff =Integer.MAX_VALUE;
            if(i +1 < n){
                int d = Math.abs(nums[i] - nums[i + 1]);
                if(d < diff){
                    ind = i + 1;
                    diff = d;
                }else if(d == diff && i + 1 < ind){
                    ind = i;
                }
            }

            if(i -1 >=0){
                int d = Math.abs(nums[i] - nums[i-1]);
                if(d < diff){
                    ind = i - 1;
                    diff = d;
                }else if(d == diff && i -1 < ind){
                    ind = i - 1;
                }
            }

            close[i] = ind;
        }

        long pre[] = new long[n];
        long suff[] = new long[n];

        for(int i=0;i<n-1;i++){
            if(close[i] == i + 1){
                pre[i+1] = pre[i] + 1;
            }else{
                pre[i+1] = pre[i] + Math.abs(nums[i+1] - nums[i]);
            }
        }

        for(int i=n-1;i>0;i--){
            if(close[i] == i-1){
                suff[i-1] = suff[i] + 1;
            }else{
                suff[i-1] = suff[i] + Math.abs(nums[i] - nums[i-1]);
            }
        }

        int q = queries.length;
        int ans[] = new int[q];
        for(int i=0;i<q;i++){
            int l = queries[i][0];
            int r = queries[i][1];

            if( l == r){
                 continue;
            }
            long a = Math.abs(nums[l] - nums[r]);
            if(l < r){
                long b = pre[r] - pre[l];
                ans[i] = (int)Math.min(a,b);
            }else{
                long b = suff[r] - suff[l];
                ans[i] =(int)Math.min(a,b);
            }
            
        }

        return ans;
    }
}