package find_the_maximum_length_of_valid_subsequence_i_3490;

class Solution {
    public int maximumLength(int[] nums) {
        int even = 0;
        int odd = 0;
        int mix = 0;
        for(int x : nums){
            if((x&1)==0){
                even++;
            }else{
                odd++;
            }
        }
        
        return Math.max(even, Math.max(odd, Math.max(calc(nums, true), calc(nums, false))));
    }
    
    private int calc(int nums[], boolean isEven){
        int cnt = 0;
        for(int x : nums){
            if(isEven && (x&1)==0){
                cnt++;
                isEven = false;
            }else if(!isEven && (x&1)==1){
                cnt++;
                isEven=true;
            }
        }
        return cnt;
    }
}