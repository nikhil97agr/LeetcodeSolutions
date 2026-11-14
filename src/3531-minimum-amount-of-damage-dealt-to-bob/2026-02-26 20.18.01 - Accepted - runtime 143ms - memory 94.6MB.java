class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        long ans = 0;
        long total = Arrays.stream(damage).mapToLong(x -> x).sum();
        int n = damage.length;
        long pair[][] = new long[n][2];
        for(int i=0;i<n;i++){
            pair[i] = new long[]{damage[i], health[i]};
        }
        Arrays.sort(pair, (a,b)->{
            long t1 = (a[1] + power - 1)/power;
            long t2 = (b[1] + power - 1)/power;

            long d1 = t1 * b[0];
            long d2 = t2 * a[0];

            return Long.compare(d1, d2);
        });

        for(long p[] : pair){
            long d = p[0];
            long h = p[1];
            long t = (h + power -1)/power;
            ans += total * t;
            total -= d;
        }

        return ans;
    }
}