package compare_sums_of_bitonic_parts_4292;

class Solution {
    public int compareBitonicSums(int[] nums) {
        int n = nums.length;
        long preSum[] = new long[n];
        long suffSum[] = new long[n];
        int preCnt[] = new int[n];
        int suffCnt[] =new int[n];
        preCnt[0] = 1;
        preSum[0] = nums[0];
        for(int i=1;i<n;i++){
            preSum[i] = preSum[i-1] + nums[i];
            if(nums[i] > nums[i - 1]){
                preCnt[i] = preCnt[i-1] + 1;
            }
            else{
                preCnt[i] = 1;
            }
        }

        suffCnt[n-1] = 1;
        suffSum[n-1] = nums[n-1];

        for(int i=n-2;i>=0;i--){
            suffSum[i] = suffSum[i+1] + nums[i];
            if(nums[i] > nums[i + 1]){
                suffCnt[i] =suffCnt[i+1] + 1;
            }else{
                suffCnt[i] = 1;
            }
        }

        for(int i=0;i<n;i++){
            if(preCnt[i] == i + 1 && suffCnt[i] == n-i){
                if(preSum[i] == suffSum[i]) return -1;
                if(preSum[i] > suffSum[i]) return 0;
                return 1;
            }
        }

        return -1;

    }
}