class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long sum  = 0;
        long diff = 0;
        
        for(int i=0;i<n;i++){
            if(nums1[i]>nums2[i]){
                diff += (long)nums1[i] - (long) nums2[i];
            }else{
                sum += (long)nums2[i] - (long)nums1[i];
            }
        }
        if(k==0){
            if(sum==0 && diff==0){
                return 0;
            }
            return -1;
        }
        
        if(sum==diff && sum%(long)k==0){
            return sum/(long)k;
        }
        return -1;
    }
}