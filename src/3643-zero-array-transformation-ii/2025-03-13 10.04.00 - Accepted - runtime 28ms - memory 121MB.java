class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        
        int s = 0;
        int e = q;
        
        int ans = -1;
        
        
        while(s <= e){
            int start[] = new int[n];
            int end[] = new int[n];
            int mid = (s+e)/2;
            for(int i=0;i<mid;i++){
                int l = queries[i][0];
                int r = queries[i][1];
                int val = queries[i][2];
                start[l]+= val;
                end[r] +=val;
            }
            int sum = 0;
            boolean possible = true;
            for(int i=0;i<n;i++){
                sum += start[i];
                
                if(nums[i] > sum){
                    possible = false;
                    break;
                }
                sum -= end[i];
            }
            
            if(possible){
                ans = mid;
                e = mid-1;
            }else{
                s = mid +1;
            }
        }
        
        
        
        return ans;
        
    }
}