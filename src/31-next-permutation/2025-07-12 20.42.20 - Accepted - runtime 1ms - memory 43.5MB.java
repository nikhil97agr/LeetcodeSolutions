class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for(int i=n-1;i>=0;i--){
            PriorityQueue<Integer> que = new PriorityQueue<>();
            int next = 101;
            int ind = -1;
            for(int j=i+1;j<n;j++){
                if(nums[j] > nums[i] && nums[j] < next){
                    next = nums[j];
                    ind = j;
                }
            }
            if(ind == -1) continue;

            for(int j=i;j<n;j++){
                if(j!=ind){
                    que.offer(nums[j]);
                }
            }

            nums[i] = next;

            for(int j=i+1;j<n;j++){
                nums[j] = que.poll();
            }

            return ;

        }

        Arrays.sort(nums);
    }
}