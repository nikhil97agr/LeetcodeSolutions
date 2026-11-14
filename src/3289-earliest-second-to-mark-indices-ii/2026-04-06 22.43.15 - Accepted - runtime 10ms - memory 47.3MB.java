class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int n = nums.length;
        int m = changeIndices.length;
        int ans = -1;
        long sum = 0;
        int firstChange[] = new int[n];
        Arrays.fill(firstChange, -1);
        for(int x : nums){
            sum += x;
        }
        for(int i=0;i<m;i++){
            int ind = changeIndices[i] - 1;
            if(nums[ind] > 0 && firstChange[ind] == -1){
                firstChange[ind] = i;
            }
        }

        int l = 0;
        int r = m;
        while(l <=r){
            var mid = (l + r)/2;
            if(check(nums, changeIndices, mid, firstChange, sum)){
                ans= mid;
                r= mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return (int)ans;
    }

    private boolean check(int nums[], int indices[], int mid, int firstChange[], long sum){
        var que = new PriorityQueue<Integer>();
        int mark = 0;
        for(int start = mid - 1;start >=0 ;start--){
            int ind = indices[start] - 1;
            if(firstChange[ind] == start){
                que.offer(nums[ind] );
                if(mark > 0){
                    mark --;
                }else{
                    mark++;
                    que.poll();
                }
            }else{
                mark ++;
            }
        }
        long s2 = que.stream().mapToLong(x -> x).sum();
        return sum - s2 + nums.length - que.size() <= mark;
    }
}