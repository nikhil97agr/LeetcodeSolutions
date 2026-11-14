package minimum_operations_to_transform_array_4042;

class Solution {
    public long minOperations(int[] nums1, int[] nums2) {
        long ans = 0;
        int n = nums1.length;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans += Math.abs(nums1[i] - nums2[i]);
            
            min = Math.min(min, find(nums1[i], nums2[i], nums2[n]));
        }

        return ans + min + 1;
    }

    private int find(int a, int b, int val){
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        if(min <= val && val <= max){
            return 0;
        }

        return Math.min(Math.abs(a -val), Math.abs(b- val));
    }
}