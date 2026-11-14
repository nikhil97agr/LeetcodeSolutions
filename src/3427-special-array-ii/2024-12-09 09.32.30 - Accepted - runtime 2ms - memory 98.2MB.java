class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        boolean ans[] = new boolean[m];
        int prefix[] = new int[n];
        for(int i=0;i<n-1;i++){
            if((nums[i]&1) == (nums[i+1]&1)){
                prefix[i+1] = prefix[i] + 1;
            }else{
                prefix[i+1] = prefix[i];
            }
            
        }
        
        for(int i=0;i<m;i++){
            int s = queries[i][0];
            int e = queries[i][1];
            int diff = prefix[e] - prefix[s];
            
            ans[i] = diff == 0 ? true : false;
        }
        return ans;
    }
}