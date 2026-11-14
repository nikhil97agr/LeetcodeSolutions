class Solution {
    public long maximumSum(List<Integer> nums) {
        int n = nums.size();

        Map<Long, Long> map = new HashMap<>();

        for(int i=1;i<=n;i++){
            generate(i, map, nums);
        }
        return map.values().stream().max(Long::compareTo).get();

    }

    private void generate(int x, Map<Long, Long> map, List<Integer> nums){
        int num = nums.get(x-1);
        long prod = 1;

        for(int i=2;i<=Math.sqrt(x);i++){
            int cnt = 0;
            while(x%i==0){
                cnt++;
                x/=i;
            }
            if(cnt%2==1){
                prod *=i;
            }
        }

        if(x > 1){
            prod *= x;
        }
        map.merge(prod, 1l*num, Long::sum);

    }
}