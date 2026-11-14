class Solution {
    public int averageValue(int[] nums) {
         nums = Arrays.stream(nums).filter(x -> {
            if(x%2==0 && x%3==0){
                return true;
            }
            return false;
         }).toArray();
        
         int n = nums.length;
         int sum = Arrays.stream(nums).sum();
        if(n==0){
            return 0;
        }
        return sum/n;
    }
}