class Solution {
    public boolean isTrionic(int[] nums) {

        int n = nums.length;

        for(int i=1;i<n;i++){
            boolean flag= true;
            for(int k=1;k<=i;k++){
                if(nums[k] <= nums[k-1]){
                    flag = false;
                    break;
                }
            }

            if(!flag) continue;
            for(int j=i+1;j<n-1;j++){
                flag = true;

                for(int k=i+1;k<=j;k++){
                    if(nums[k] >= nums[k-1]){
                        flag = false;
                        break;
                    }
                }
                if(!flag) continue;

                for(int k=j+1;k<n;k++){
                    if(nums[k] <= nums[k-1]){
                        flag = false;
                        break;
                    }
                }

                if(!flag) continue;

                return true;
            }
        }

        return false;
    }
}