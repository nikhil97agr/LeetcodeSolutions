class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int ind[]= new int[Arrays.stream(nums2).max().getAsInt()+1];
        int ans[] = new int[nums1.length];
        for(int i=0;i<nums2.length;i++){
            ind[nums2[i]] = i;
        }
        for(int i=0;i<nums1.length;i++){
            ans[i] = ind[nums1[i]];
        }

        return ans;
    }
}