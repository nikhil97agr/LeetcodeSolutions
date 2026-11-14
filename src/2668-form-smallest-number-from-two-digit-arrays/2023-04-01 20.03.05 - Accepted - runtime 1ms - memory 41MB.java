class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int count[] = new int[10];
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int x : nums1){
            count[x]++;
        }
        
        for(int x : nums2){
            if(count[x]>0){
                return x;
            }
        }

        
        return Math.min(nums1[0], nums2[0])*10 + Math.max(nums1[0], nums2[0]);
    }
}