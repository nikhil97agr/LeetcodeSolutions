class Solution {
    public int findMaximizedCapital(int k, int w, int[] p, int[] c) {
        int n = p.length;
        int data[][] = new int[n][2];

        for(int i=0;i<n;i++){
            data[i] = new int[]{p[i], c[i]};
        }

        Arrays.sort(data, (d1, d2)-> d1[1] - d2[1]);
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int j=0;
        for(int i=0;i<k;i++){
            while(j<n && data[j][1]<=w){
                que.offer(new int[]{data[j][0], data[j][1]});
                j++;
            }

            if(que.isEmpty()) break;

            int d[] = que.poll();

            w += d[0];
        }

        return w;
    }
}