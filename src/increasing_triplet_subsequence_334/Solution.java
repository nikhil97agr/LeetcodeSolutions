package increasing_triplet_subsequence_334;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n<3){
            return false;
        }
        int start = Integer.MAX_VALUE;
        int end = Integer.MAX_VALUE;
        for(int x  :nums){
            if(x <= start){
                start = x;
            }else if(x <= end){
                end = x;
            }else{
                return true;
            }
        }
        return false;
    }
}