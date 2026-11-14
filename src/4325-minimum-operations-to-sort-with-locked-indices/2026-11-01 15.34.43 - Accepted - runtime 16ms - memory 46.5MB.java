class Solution {
    public int minOperations(int[] nums, int[] locked, int k) {
        int ans = 0;
        int unlock = 0;
        int n = nums.length;
        int req = 1;
        for(int i=0;i<n;i++){
            int ind = -1;
            for(int j=i;j < n;j++){
                if(nums[j] == req){
                    ind = j;
                    break;
                }
            }

            if(ind == i) {
                req++;
                continue;
            };
            if(locked[ind] == 1){
                locked[ind]= 0;
                unlock++;
            }
            for(int j= ind - 1;j >=i;j--){
                if(locked[j] == 1){
                    locked[j] = 0;
                    unlock++;
                }

                int temp = nums[j + 1];
                nums[j + 1] = nums[j];
                 nums[j] = temp;
                 ans++;
            }

            req++;
        }


        return unlock <=k ? ans + unlock : -1;


        
    }
}