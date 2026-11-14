class Solution {
    public long maxSum(int[] nums, int k) {
        long ans = -1_000_000_000_000_0L;

        int clone[] = nums.clone();
        Arrays.sort(clone);
        var n = nums.length;
        for(int i=0;i<n;i++){
            long sum = 0;

            var excluded = new TreeMap<Integer, Integer>();
            var included = new TreeMap<Integer, Integer>();

            for(int j=0;j<n-k;j++){
                add(excluded, clone[j]);
            }

            for(int j=n-k;j<n;j++ ){
                add(included, clone[j]);
            }

            for(int j=i;j<n;j++){
                if(!excluded.isEmpty()){
                    if(excluded.containsKey(nums[j])){
                        add(included, nums[j]);
                        remove(excluded, nums[j]);
                    }else{
                        int max = excluded.lastKey();
                        add(included, max);
                        remove(excluded, max);
                    }
                }

                sum += included.lastKey();
                remove(included, included.lastKey());

                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }

    private void add(Map<Integer, Integer> map, int val){
        map.merge(val, 1, Integer::sum);
    }

    private void remove(Map<Integer, Integer> map, int val){
        map.merge(val, -1, Integer::sum);
        if(map.get(val) ==0){
            map.remove(val);
        }
    }
}