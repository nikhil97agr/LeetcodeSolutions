class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int cnt[] = new int[10001];

        for(int x : barcodes) cnt[x]++;
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int i=0;i<=10000;i++){
            if(cnt[i] > 0) que.offer(new int[]{cnt[i], i});
        }
        int n = barcodes.length;

        int ans[] = new int[n];
        int i=0;
        while(!que.isEmpty()){
            int next[] = que.poll();
            int c = next[0];
            int val = next[1];
            while(c-- > 0){
                ans[i] = val;
                i+=2;
                if(i>=n){
                    i = 1;
                }
            }
        }

        return ans;
    }
}