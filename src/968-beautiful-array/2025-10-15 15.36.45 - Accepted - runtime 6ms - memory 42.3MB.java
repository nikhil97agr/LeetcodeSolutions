class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();

        result.add(1);

        while(result.size() < n){
            List<Integer> list = new ArrayList<>();
            for(int x : result){
                if(2*x -1 <= n) list.add(2 * x - 1);

            }

            for(int x : result){
                if(2*x <=n ) list.add(2*x);
            }
            result = list;
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}