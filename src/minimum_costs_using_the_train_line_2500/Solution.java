package minimum_costs_using_the_train_line_2500;

class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        int n = regular.length;
        long ans[] = new long[n];
        long prev[] = new long[]{0, expressCost};
        for(int i=1;i<=n;i++){
            long up = Math.min(prev[0] + regular[i-1], prev[1] + Math.min(express[i-1], regular[i-1]));
            long down = Math.min(
                prev[1] + express[i-1],
                prev[0] + expressCost + Math.min(
                    regular[i-1] ,
                    express[i-1]
                )
            );

            ans[i-1] = Math.min(up, down);
            prev[0] = up;
            prev[1] = down;
        }

        return ans;
    }
}