package minimum_deletions_to_make_array_sharp_4430;

class Solution {
    public int minDeletions(int[] nums) {
        int ans = 0;
        int prev = -1;
        for(int x : nums){
            if(prev == x){
                ans++;
            }else{
                prev = x;
            }
        }
        return ans;
    }
}