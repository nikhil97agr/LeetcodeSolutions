class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int start =0;
        int end= nums2.length - 1;
        int ans = 0;
        while(start < nums2.length){
            ans += nums1[start] * nums2[end];
            start++;
            end--;
        }

        return ans;
    }
}