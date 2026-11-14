class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] eng = new int[n][2];
        for(int i=0;i<n;i++)
        {
            eng[i] = new int[]{speed[i], efficiency[i]};
        }
        
        Arrays.sort(eng, (e1,e2)->e2[1]-e1[1]);
        PriorityQueue<Integer> pq = new PriorityQueue();
        long MOD = (long)1e9+7;
        long sum = 0;
        long total = 0;
        for(int[] e : eng)
        {
            if(pq.size()==k)
            {
                sum -= pq.poll();
            }
            pq.add(e[0]);
            sum += e[0];
            total = Math.max(total, sum*e[1]);
        }
        return (int)(total%MOD);
    }
}