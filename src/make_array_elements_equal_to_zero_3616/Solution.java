package make_array_elements_equal_to_zero_3616;

class Solution {
    public int countValidSelections(int[] nums) {
         int n = nums.length;
        int ans = 0;
        
        for(int i=0;i<n;i++){
            if(nums[i] == 0 && possible(-1, nums.clone(), i)) ans++;
            if(nums[i] == 0 && possible(1, nums.clone(), i)) ans++;
        }
        return ans;
    }
    
    private boolean possible(int dir, int nums[], int i){
        int j = i;
        int n = nums.length;
        while(i < n && i >= 0){
            if(nums[i] == 0){
                i+=dir;
                continue;
            }
            nums[i]--;
            if(dir == -1) dir = 1;
            else dir = -1;
            i += dir;
        }
        
        for(int x : nums) if(x!=0) return false;
        
        return true;
    }
}