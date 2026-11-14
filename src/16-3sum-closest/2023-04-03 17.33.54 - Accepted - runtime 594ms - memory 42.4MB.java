class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int sum = nums[i] + nums[j]  + nums[k];
                    
                    int d = Math.abs(target - sum);
                    if(d<diff){
                        diff = d;
                        ans = sum;
                    }
                }
            }
        }


        return ans;
    }
}