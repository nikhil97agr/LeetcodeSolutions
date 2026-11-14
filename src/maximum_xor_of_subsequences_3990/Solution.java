package maximum_xor_of_subsequences_3990;

class Solution {
    public int maxXorSubsequences(int[] nums) {
        int ind = 0;
        int n = nums.length;
        for(int i=30;i>=0;i--){
            int max = Integer.MIN_VALUE;
            int maxInd = -1;
            for(int j=ind;j<n;j++){
                if((nums[j] & (1<<i)) !=0 && nums[j] > max){
                    max = nums[j];
                    maxInd = j;
                }
            }

            if(max == Integer.MIN_VALUE) continue;
            int temp = nums[ind];
            nums[ind] = nums[maxInd];
            nums[maxInd] = temp;

            maxInd = ind;

            for(int j=0;j<n;j++){
                if(j == maxInd || (nums[j] & (1<<i))==0) continue;
                nums[j] ^= nums[maxInd];
            }

            ind++;
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            ans ^= nums[i];
        }

        return ans;
    }
}