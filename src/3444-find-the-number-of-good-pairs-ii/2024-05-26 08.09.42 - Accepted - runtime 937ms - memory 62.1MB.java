class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long ans = 0;
        Map<Long, Long> map = new HashMap<>();
        for(int x : nums2){
            long n = 1L*x*k;
            
            map.put(n, map.getOrDefault(n, 0L)+1);
        }
        
        for(int x : nums1){
            ans += solve(1L*x, map);
        }
        return ans;    
    }
    
    private long solve(long x, Map<Long, Long> map){
        long ans = 0;
        for(long i=1;i<=Math.sqrt(x);i++){
            if(x%i == 0){
                long y = x/i;
                if(i==y){
                    ans += map.getOrDefault(i, 0L);
                }else{
                     ans += map.getOrDefault(i, 0L) + map.getOrDefault(y, 0L);
                }
            }
        }
        return ans;
    }
    
}