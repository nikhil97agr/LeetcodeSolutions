class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int ans[] = new int[n];
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        Arrays.sort(nums1);
        for(int i=0;i<nums2.length;i++){
            que.offer(new int[]{nums2[i], i});
        }

        int ind = 0;

        while(ind < n){
            while(ind < n && nums1[ind] <= que.peek()[0]){
                ind++;
            }

            if(ind  < n ){
                int peek[] = que.poll();
                ans[peek[1]] = nums1[ind];
                nums1[ind] = -1;
                ind++;
            }
        }
         ind = 0;
        while(!que.isEmpty()){
            while( nums1[ind] == -1) ind++;

            int peek[] = que.poll();

            ans[peek[1]] = nums1[ind];
            ind++;
        }

        return ans;
    }
}