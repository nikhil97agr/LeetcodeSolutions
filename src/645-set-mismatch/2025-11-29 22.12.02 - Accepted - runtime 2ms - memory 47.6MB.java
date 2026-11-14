class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]%n==0){
                nums[n-1] += n;
            }else{
            nums[nums[i]%n-1]+=n;

            }
        }
        int result[] = new int[2];
        for(int i=0;i<n;i++){
            if(nums[i]<=n){
                result[1] = i+1;
            }
            if(nums[i]>n*2){
                result[0] = i+1;
            }
        }
        return result;
    }
}