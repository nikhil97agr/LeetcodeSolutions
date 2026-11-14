class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n==1){
            return false;
        }
        int total = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            total += nums[i];
            if(total%k==0){
                if(i==0){
                    map.put(total%k, i);
                }
                else{
                    return true;
                }
                continue;
            }
            if(map.containsKey(total%k)){
                if(i-map.get(total%k)>1){
                    return true;
                }
            }else{
                map.put(total%k, i);
            }
            
        }
        return false;
    }
}