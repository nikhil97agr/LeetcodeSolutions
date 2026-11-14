class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;

        for(int i=0;i<nums1.length;i++){
            int start = i;
            int end = nums2.length - 1;
            int j = -1;
            while(start <= end){
                int mid = (start + end)/2;

                if(nums2[mid] < nums1[i]){
                    end = mid - 1;
                }else{
                    j = mid;
                    start = mid + 1;
                }
            }

            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}