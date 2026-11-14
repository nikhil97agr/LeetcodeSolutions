package minimum_swaps_to_make_sequences_increasing_819;

class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int notChange = 0;
        int change = 1;

        for(int i=1;i<n;i++){
            int newChange = Integer.MAX_VALUE;
            int newNotChange= Integer.MAX_VALUE;
            if(nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1]){
                newChange = Math.min(newChange, change + 1);
                newNotChange = Math.min(newNotChange, notChange);
            }
            if(nums1[i] > nums2[i-1] && nums2[i] > nums1[i-1]){
                newNotChange = Math.min(newNotChange, change);
                newChange = Math.min(newChange, notChange +1);
            }
            
            change= newChange;
            notChange= newNotChange;

        }

        return Math.min(change, notChange);
    }
}