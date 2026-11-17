package ant_on_the_boundary_3311;

class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int curr = 0;
        int cnt = 0;
        for(int x : nums){
            curr += x;
            if(curr == 0)cnt++;
        }
        
        return cnt;
    }
}