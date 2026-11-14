class Solution {
    public int minPatches(int[] nums, int n) {
        long next = 1;
        int count =0;
        int i=0;
        while(next <= 1l*n){
            if(i < nums.length && 1l*nums[i] <= next){
                next += 1l*nums[i];
                i++;
            }else{
                count++;
                next+=next;
            }
        }
        return count;
    }
}