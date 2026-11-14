class Solution {
    public long minimumMoves(int[] nums, int k, int maxChanges) {
        List<Long> preSum = new ArrayList<>();
        long prev = 0l;
        long ans = (long)1e15;
                var n = nums.length;

        List<Integer> oneIndex= new ArrayList<>();
        if(maxChanges >= k){
            ans = k * 2;
            for(int i=0;i<n;i++){
                if(nums[i] == 1){
                    long steps = 0;
                    long remain = k-1;
                    if(remain > 0 && i -1 >=0 && nums[i-1] ==1){
                        remain--;
                        steps++;
                    }

                    if(remain > 0 && i +1 < n && nums[i+1] == 1){
                        remain--;
                        steps++;
                    }

                    ans = Math.min(ans, steps + 2 * remain);

                }
            }

            return ans;
        }

        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                oneIndex.add(i);
                prev += i;
                preSum.add(prev);
            }
        }

        int step2 = k - maxChanges;

        for(int window = step2; window <= step2 + 2;window++){
            if(window > k) break;

            for(int i=0;i < oneIndex.size();i++){
                int j = i + window -1 ;

                if( j >= oneIndex.size()) break;

                int midIndex = (i + j) / 2;
                long midValue = oneIndex.get(midIndex);
                long currMove = (k - window) * 2;
                long leftMove = midValue * (midIndex -i) - getSum(i, midIndex -1, preSum);
                long rightMove = getSum(midIndex + 1, j, preSum) - (j - midIndex)*midValue;
                currMove += leftMove + rightMove;

                ans = Math.min(ans, currMove);

            }
        }

        return ans;
    }

    private long getSum(int l, int r, List<Long> prefix){
        if( l > r) return 0;
        if(l==0) return prefix.get(r);
        return prefix.get(r) - prefix.get(l-1);
    }
}