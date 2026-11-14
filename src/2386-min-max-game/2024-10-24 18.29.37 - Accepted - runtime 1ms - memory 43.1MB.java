class Solution {
    public int minMaxGame(int[] nums) {
        int n = nums.length;

        while(n > 1){
            n/=2;
            int newArr[] = new int[n];

            for(int i=0;i<n;i++){
                if(i%2==0){
                    newArr[i] = Math.min(nums[2*i], nums[2*i+1]);
                }else{
                    newArr[i] = Math.max(nums[2*i], nums[2*i+1]);
                }
            }

            nums = newArr;


        }

        return nums[0];
    }
}