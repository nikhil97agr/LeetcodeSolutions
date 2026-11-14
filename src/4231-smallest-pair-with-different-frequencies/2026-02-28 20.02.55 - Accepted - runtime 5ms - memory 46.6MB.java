class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int cnt[] = new int[101];
        for(int x : nums){
            cnt[x]++;
        }
        for(int x : nums){
            for(int y : nums){
                if(x < y && cnt[x] != cnt[y]){
                    if(x < x1){
                        x1 = x;
                        y1 = y;
                    }else if(x == x1 && y < y1){
                        y1 = y;
                    }
                }
            }
        }
        if(x1 == Integer.MAX_VALUE) return new int[]{-1,-1};
        return new int[]{x1, y1};
    }
}