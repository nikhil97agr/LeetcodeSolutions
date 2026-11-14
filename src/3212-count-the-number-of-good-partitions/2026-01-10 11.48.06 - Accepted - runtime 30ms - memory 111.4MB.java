class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        List<int[]> list = new ArrayList<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            lastIndex.put(nums[i], i);
        }
        int end = 0;
        int cnt = 0;
        while(end < n){
            int s = end;
            int e = lastIndex.get(nums[end]);
            while(end < e){
                e = Math.max(e, lastIndex.get(nums[end]));
                end++;
            }
            cnt++;
            end++;
        }
        return pow(2, cnt-1);
    }
    private int pow(int a, int b){
        if( a <= 1) return a;
        if(b==0) return 1;
        if(b==1) return a;
        int p = pow(a, b/2);
        p = prod(p,p);
        if(b%2==1){
            p = prod(p, a);
        }

        return p;
    }

    private int prod(int a, int b){
        int mod = (int)1e9 + 7;
        long prod = 1l*a*b;

        return (int)(prod%mod);
    }
}