class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        int i=0;
        int j = n-1;
        for(int x : nums){
            if(x%2==0) res[i++] = x;
            else res[j--] = x;
        }
        return res;
    }
}