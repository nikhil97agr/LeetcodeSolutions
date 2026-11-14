class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int prod = nums[i] * nums[j];
                map.put(prod, map.getOrDefault(prod, 0)+1);
            }
        }
        int ans = 0;
        for(int val : map.values()){
            if(val> 1){
                ans += val*(val-1)*4;
            }
        }
        return ans;
    }
}