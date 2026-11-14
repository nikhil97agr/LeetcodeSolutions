package remove_one_element_to_make_the_array_strictly_increasing_2020;

class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int n= nums.length;

        for(int i=0;i<n;i++){
            int prev = (i==0) ? 1 : 0;

            boolean found= true;
            for(int j=prev+1;j<n;j++){
                if(i==j) continue;
                if(nums[j] <= nums[prev]){
                    found= false;
                    break;
                }else{
                    prev = j;
                }
            }

            if(found) return true;
        }

        return false;
    }
}