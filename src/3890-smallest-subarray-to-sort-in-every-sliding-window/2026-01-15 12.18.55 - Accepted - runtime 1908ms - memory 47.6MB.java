class Solution {
    public int[] minSubarraySort(int[] nums, int k) {
        int n = nums.length;

        int ans[] = new int[n-k+1];
        int ind = 0;
        for(int i=0;i+k<=n;i++){
            ans[ind] = cnt(nums, i, i+k-1);
            ind++;
        }

        return ans;
    }

    private int cnt(int nums[], int start, int end){
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=start;i<=end;i++){ que.offer(nums[i]);}

        int s = -1;
        int e = -1;

        for(int i=start;i<=end;i++){
            if(nums[i]== que.peek()){
                que.poll();
                continue;
            }
            if(s == -1) s = i;
            e = i;
            que.poll();
        }

        return s == -1 ? 0 : e - s + 1;
    }
}