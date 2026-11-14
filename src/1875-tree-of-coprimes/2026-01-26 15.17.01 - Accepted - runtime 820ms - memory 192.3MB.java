class Solution {
    public int[] getCoprimes(int[] nums, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i=1;i<=50;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=1;j<=50;j++){
                int gcd = gcd(i, j);
                if(gcd == 1){
                    set.add(j);
                }

            }

            map.put(i, set);
        }

        int n = nums.length;
        List<Integer> list[] = new ArrayList[n];
        for(int i=0;i<n;i++) list[i] = new ArrayList<>();
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            list[u].add(v);
            list[v].add(u);
        }
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        for(int i=1;i<=50;i++){
            dfs(ans, 0, -1, -1, i, map.get(i), list, nums);
        }

        return ans;
    }

    private void dfs(int ans[], int curr, int par, int val, int v, Set<Integer> set, List<Integer> list[], int nums[]){

        if(nums[curr] == v){
            ans[curr] = val;
        }

        for(int child : list[curr]){
            if(child == par) continue;

            dfs(ans, child, curr, set.contains(nums[curr]) ? curr : val, v, set, list, nums);
        }

    }

    private int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}