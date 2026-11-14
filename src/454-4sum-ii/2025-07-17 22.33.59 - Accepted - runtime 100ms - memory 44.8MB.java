class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans= 0 ;

        int n = nums1.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map.merge(nums1[i] + nums2[j], 1, Integer::sum);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum = nums3[i] + nums4[j];

                ans += map.getOrDefault(-sum, 0);
            }
        }
        
        return ans;
    }
}