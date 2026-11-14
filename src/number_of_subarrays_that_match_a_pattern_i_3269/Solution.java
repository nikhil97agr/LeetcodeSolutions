package number_of_subarrays_that_match_a_pattern_i_3269;

class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n = nums.length;
        int cnt = 0;
        int m = pattern.length;
        
        for(int i=0;i<n;i++){
            boolean possible = true;
            if(i+m>=n)break;
            
            for(int k=0;k<m;k++){

                switch(pattern[k]){
                    case 1:
                        if(nums[i+k+1]<=nums[i+k]){
                            possible = false;
                        }
                        
                        break;
                    case -1:
                        if(nums[i+k+1]>= nums[i+k]){
                            possible = false;
                        }
                        
                        break;
                    case 0:
                        if(nums[i+k+1] != nums[i+k]){
                            possible = false;
                        }
                        
                        break;
                }
                if(!possible){
                    break;
                }
            }
            if(possible){
                cnt++;
            }
        }
        return cnt;
    }
}