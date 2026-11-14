class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int start =0;
        int n = nums.length;
        int end = nums[n-1] - nums[0];
        while(start < end){
            int mid = start + (end - start)/2;

            if(check(nums, n, p, mid)){
                end = mid;
            }else{
                start = mid+1;
            }
        }

        return start;
    }

    private boolean check(int nums[], int n, int p, int mid){
        int cnt = 0;
        for(int i=0;i<n-1;i++){
            if(nums[i+1] - nums[i] <= mid){
                cnt++;
                i++;
            }
        }
        return cnt >= p;
    }
}