class Solution {
    public long minMoves(int[] balance) {
        long sum = Arrays.stream(balance).mapToLong(x->1l*x).sum();
        long cnt = Arrays.stream(balance).filter(x-> x < 0).count();
        if(sum < 0l) return -1;
        if(cnt ==0l) return 0;

        int ind = -1;
        int n= balance.length;
        for(int i=0;i<n;i++){
            if(balance[i] < 0) {
                ind = i;
                break;
            }
        }

        List<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i == ind) continue;

            int d1 = Math.abs( i - ind);
            int d2 = (n-1 - i) + (ind + 1);
            int d3 = i + (n - ind);
            list.add(new int[]{Math.min(d1, Math.min(d2, d3)), balance[i]});
        }
        long ans = 0;
        Collections.sort(list, (a,b) -> a[0] - b[0]);
        long req = Math.abs(balance[ind]);
        int i = 0;
        while(req > 0){
            int next[] = list.get(i);

            long min = Math.min(next[1], req);
            ans += min * next[0];
            i++;
            req -= min;
        }

        return ans;

    }
}