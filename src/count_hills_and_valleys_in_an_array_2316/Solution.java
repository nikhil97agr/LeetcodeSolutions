package count_hills_and_valleys_in_an_array_2316;

class Solution {
    public int countHillValley(int[] nums) {
        int ans = 0;
        String prev = null;
        for(int i=0;i<nums.length;i++){
            int left = nums[i];
            int right = nums[i];
            for(int j=i-1;j>=0;j--){
                if(nums[j] != nums[i]){
                    left = nums[j];
                    break;
                }
            }
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] != nums[i]){
                    right = nums[j];
                    break;
                }
            }

            if(left < nums[i] && right < nums[i]){
                if(prev != "H"){
                    ans++;
                    prev = "H";
                }
            }else if(left > nums[i] && right > nums[i]){
                if(prev != "V"){
                    ans++;
                    prev = "V";
                }
            }else{
                prev = null;
            }
        }
        return ans;
    }
}