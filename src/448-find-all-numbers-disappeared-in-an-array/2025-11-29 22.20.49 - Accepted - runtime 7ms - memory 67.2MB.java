class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int ind = nums[i]%n;
            if(ind == 0){
                ind = n;
            }
            ind = (ind -1 )%n;
            nums[ind]+=n;
            if(nums[ind] / n > 2){
                nums[ind] -=n;
            }
        }
        for(int i=0;i<n;i++){
            if((nums[i]/n)==0 || (nums[i]==n)){
                result.add(i+1);
            }
        }
        return result;
    }
}