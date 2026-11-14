package transform_array_to_all_equal_elements_3876;

class Solution {
    public boolean canMakeEqual(int[] arr, int k) {
        int n = arr.length;
        int cnt = 0;
        int nums[] = arr.clone();
        int temp = k;
        for(int i=0;i<n-1;i++){
            if(nums[i] == -1 && temp > 0){
                nums[i] = 1;
                nums[i+1] = nums[i+1]*-1;
                temp--;
            }
        }
        boolean found = true;
        for(int x : nums){
            if(x==-1) {
                
                found = false;
                break;}
        }

        if(found) return true;

        nums = arr.clone();

        for(int i=0;i<n-1;i++){
            if(nums[i] == 1 && k > 0){
                nums[i] = -1;
                nums[i+1] = nums[i+1]*-1;
                k--;
            }
        }

        for(int x : nums){
            if(x==1) return false;
        }

        return true;

        
    }
}