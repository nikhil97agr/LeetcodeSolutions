class Solution {
    public int[] rearrangeArray(int[] nums) {
        int even = 0;
        int n =nums.length;
        int odd = 1;
        int i =0;
        int result[] = new int[n];
        while(even<n && odd<n){
            if(nums[i]>=0){
                result[even] = nums[i++];
                even+=2;
                continue;
            }
            
            result[odd] = nums[i++];
            odd+=2;
            continue;
        }
        
        while(even<n){
            result[even] = nums[i++];
            even+=2;
        }
        while(odd<n){
            result[odd] = nums[i++];
            odd+=2;
        }
        return result;
    }
}