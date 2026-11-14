class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;

        return Math.max(solve(nums1, nums2, n), solve(nums2, nums1, n));
    }

    private int solve(int a[], int b[], int n){
        int sum = Arrays.stream(a).sum();

        int curr = 0;
        int max= 0;
        for(int i=0;i<n;i++){
            int diff = b[i] - a[i];
            curr = Math.max(diff, curr + diff);
            max = Math.max(curr,  max);

        }

        return sum + max;
    }
}