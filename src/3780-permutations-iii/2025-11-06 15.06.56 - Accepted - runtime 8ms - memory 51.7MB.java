class Solution {
    public int[][] permute(int n) {
        List<int[]> result = new ArrayList<>();
        generate(0, new boolean[n+1], 0, new int[n], n, result);
        generate(1, new boolean[n+1], 0, new int[n], n, result);

        Collections.sort(result, (a,b) -> Arrays.compare(a,b));
        return result.stream().toArray(int[][]::new);
    }

    private void generate(int next, boolean vis[], int ind, int arr[], int n, List<int[]> result){
        if(ind == n){
            result.add(arr.clone());
            return;
        }

        for(int i=1;i<=n;i++){
            if(!vis[i] && i%2==next){
                arr[ind] = i;
                vis[i] = true;
                generate(next^1, vis, ind+1, arr, n, result );
                vis[i] = false;
            }
        }
    }
}