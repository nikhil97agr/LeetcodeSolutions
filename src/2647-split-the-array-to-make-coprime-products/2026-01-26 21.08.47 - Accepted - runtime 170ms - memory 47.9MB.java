class Solution {
    public int findValidSplit(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int x = nums[i];
            for(int p=2;p*p <= x;p++){
                if(x%p==0){
                    map.put(p, i);
                    while(x%p==0) x/=p;
                }
            }

            if(x > 1){
                map.put(x, i);
            }
        }

        int rightIndex = 0;

        for(int i=0;i<n-1;i++){
            int x = nums[i];
            for(int p=2;p*p <= x;p++){
                if(x%p==0){
                    rightIndex = Math.max(rightIndex, map.get(p));
                    while(x%p==0) x/=p;
                }
            }
            if(x > 1){
                rightIndex = Math.max(rightIndex, map.get(x));
            }

            if(rightIndex ==i) return i;
        }

        return -1;
    }
}