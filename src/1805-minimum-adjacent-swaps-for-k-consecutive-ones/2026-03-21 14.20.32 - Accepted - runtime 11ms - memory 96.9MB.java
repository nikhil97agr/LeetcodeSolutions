class Solution {
    public int minMoves(int[] nums, int k) {
        if(k == 1 || k == nums.length) return 0;
        int n = nums.length;
        List<Integer> ones = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                ones.add(i);
            }
        }
        int m= ones.size();
        int adjusted[] = new int[m];

        for(int i=0;i<m;i++){
            adjusted[i] = ones.get(i) - i;
        }

        long pre[] = new long[m];

        pre[0] = adjusted[0];
        for(int i=1;i<m;i++){
            pre[i] = pre[i-1] + adjusted[i];
        }
        long ans = Long.MAX_VALUE;
        for(int i=0;i<=m-k;i++){
            int end = i + k -1;
            int mid = (i +end)/2;
            long median = adjusted[mid];
            var leftCount = mid - i + 1;
            long sumLeft = 0;

            if(i==0){
                sumLeft = pre[mid];
            }else{
                sumLeft = pre[mid] - pre[i-1];
            }
            long leftCost = median * leftCount - sumLeft;

            int rightCount =end - mid;
            long rightSum = 0;
            if(mid < end){
                rightSum= pre[end] - pre[mid];
            }

            long rightCost = rightSum - median * rightCount;
            ans = Math.min(ans, leftCost + rightCost);
        }

        return (int)ans;
    }

}