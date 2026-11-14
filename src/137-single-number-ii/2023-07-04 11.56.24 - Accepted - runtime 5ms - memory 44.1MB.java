class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        int n = nums.length;
        boolean negat = false;
        for(int i=0;i<32;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                count += nums[j]%2;
                nums[j]/=2;
            }
            if(count%3!=0){
                result += 1<<i;
            }
            if(count%3==-1 || count%3==2){
                negat = true;
            }
        }
        return negat? -result : result;

    }
}