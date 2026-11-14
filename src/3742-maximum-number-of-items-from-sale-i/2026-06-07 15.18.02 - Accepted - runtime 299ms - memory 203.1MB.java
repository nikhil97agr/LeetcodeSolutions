class Solution {
    Integer dp[][];
    public int maximumSaleItems(int[][] items, int budget) {
        Map<Integer, Integer> map = new HashMap<>();
        int minPrice = Integer.MAX_VALUE;
        for(int i[] : items){
            compute(map, i[0]);
            minPrice = Math.min(minPrice, i[1]);
        }
        dp = new Integer[items.length][budget + 1];
        return solve(0, items, budget, items.length, map, minPrice);
    }

    private int solve(int i, int items[][], int budget, int n, Map<Integer, Integer> map, int min){
        if(budget <= 0){
            return 0;
        }

        if(i == n) return budget / min;

        if(dp[i][budget] !=null) return dp[i][budget];

        int c1 = solve(i + 1, items, budget, n, map, min);
        int p = items[i][1];
        int f = items[i][0];
        int c2 = 0;
            int free = map.get(f) - 1;

        if(p <= budget){

            c2 = free + 1 + solve(i+1, items, budget - p, n, map, min);
        }

        return dp[i][budget] = Math.max(c1,  c2);
    }

    private void compute(Map<Integer, Integer> map, int factor){

        for(int i=1;i<=Math.sqrt(factor);i++){
            if(factor%i==0){
                map.merge(i, 1, Integer::sum);
                if(factor/i != i){
                    map.merge(factor/i, 1, Integer::sum);
                }
            }
        }
    }
}