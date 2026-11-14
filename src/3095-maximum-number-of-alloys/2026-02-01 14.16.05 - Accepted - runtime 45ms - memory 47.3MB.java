class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int ans = 0;
        int min = 0;
        int max = Integer.MAX_VALUE;

        while(min <= max){
            int mid = min + (max-min)/2;

            boolean flag = false;
            for(int i=0;i<k;i++){
                if(possible(budget, mid, composition.get(i), new ArrayList<>(stock), cost, n)){
                    flag= true;
                     break;
                }
            }


            if(flag){
                ans = mid;
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }

        return ans;
    }

    private boolean possible(int budget, int required, List<Integer> machine, List<Integer> stock, List<Integer> cost, int n){
        long c = 0;

        for(int i=0;i<n;i++){
            long needed = 1l*machine.get(i) * required;
            long extra = Math.max(0, needed -stock.get(i));
            c += extra * cost.get(i);
        }

        return c <= 1l*budget;
    }

}