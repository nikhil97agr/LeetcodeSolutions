class Solution {
    public int maximumMatchingIndices(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            rightShift(nums1);
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(nums1[j] == nums2[j]) cnt++;
            }

            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    private void rightShift(int arr[]){
        int n = arr.length;

        int val = arr[n-1];
        for(int i=n-1;i>0;i--){
            arr[i] = arr[i-1];
        }

        arr[0] = val;
    }
    
}