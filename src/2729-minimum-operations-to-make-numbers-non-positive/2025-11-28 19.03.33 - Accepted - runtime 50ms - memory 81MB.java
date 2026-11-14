class Solution {
    public int minOperations(int[] nums, int x, int y) {
        int n = nums.length;
        int start = 0;
        int end = Integer.MAX_VALUE;

        while(start <= end){
            int mid = start + (end -start)/2;

            long temp[] = new long[n];

            for(int i=0;i<n;i++){
                temp[i]= nums[i];
            }

            for(int i=0;i<n;i++){
                temp[i] -= 1l*mid*y;

            }
            long op= 0;
            int left = x - y;
            for(long z : temp){
                if(z > 0){
                    op += (z + left-1)/left;
                }
            }

            if(op <= mid){
                end = mid - 1;
            }else{
                 start = mid + 1;
            }
        }

        return end+1;
    }
}