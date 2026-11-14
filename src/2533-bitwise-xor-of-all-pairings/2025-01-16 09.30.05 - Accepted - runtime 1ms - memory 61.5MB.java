class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int ans = 0;

        if(n%2!=0){
            for(int x: nums2){
                ans^= x;
            }
        }

        if(m%2!=0){
            for(int x : nums1){
                ans ^= x;
            }
        }
        return ans;
    }
}