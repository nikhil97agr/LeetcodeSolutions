class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
       int n = nums.size();

       for(int i=0;i<n;i++){
        int j=i+1;
        boolean found= true;
        if(j+k >n) break;
        for(;j<i+k;j++){
            if(nums.get(j) <= nums.get(j-1)){
                found= false;
                break;
            }
        }
        if(!found) continue;
        
        if(j+k <=n){
            int l = j+1;
            for(;l< j+k;l++){
                if(nums.get(l) <= nums.get(l-1)){
                    found=false;
                    break;
                }
            }
            if(found) return true;
        }else{
            break;
        }
       }
       return false; 
    }
}