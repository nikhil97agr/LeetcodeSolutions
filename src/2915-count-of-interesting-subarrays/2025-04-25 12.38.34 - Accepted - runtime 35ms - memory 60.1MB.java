class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long ans = 0;

        int n = nums.size();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            int mod = nums.get(i)%modulo;
            if(mod ==k) arr[i] = 1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,1);
        for(int x : arr){
            sum += x;

            ans += map.getOrDefault((sum - k + modulo)%modulo, 0);
            map.put(sum%modulo, map.getOrDefault(sum%modulo,0)+1);
        }

        return ans;
    }
}