class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int pairs[][] = new int[n][2];
        for(int i=0;i<n;i++){
            pairs[i] = new int[]{nums1[i], nums2[i]};

        }

        Arrays.sort(pairs, (a,b)->b[1]-a[1]);

        long sum = 0;
        long ans = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            sum += pairs[i][0];
            que.add(pairs[i][0]);
        }

        ans = sum * pairs[k-1][1];
        for(int i=k;i<n;i++){
            sum += pairs[i][0] - que.poll();
            ans = Math.max(ans, sum*pairs[i][1]);
            que.add(pairs[i][0]);
        }

        return ans;
    }
}