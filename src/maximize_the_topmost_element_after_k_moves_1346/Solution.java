package maximize_the_topmost_element_after_k_moves_1346;

class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if(n==1){
            if(k%2==1) return -1;
            return nums[0];
        }
        int max= -1;
        
        for(int i=0;i<n;i++){
            if(i > k) break;
            int left = k-i;
            if(left == 1) continue;
            if(left%2==0 || (n-1) > 0)
             max = Math.max(max, nums[i]);
        }


        return max;

    }
}