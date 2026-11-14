class Solution {
    public int componentValue(int[] nums, int[][] edges) {
        int total = Arrays.stream(nums).sum();
        int n = nums.length;
        List<Integer> list[] = new ArrayList[n];

        for(int i=0;i<n;i++){ 
            list[i] = new ArrayList<>();
        }

        for(int e[] :edges){
            int u = e[0];
            int v = e[1];
            list[u].add(v);
            list[v].add(u);
        }

        int ans = 0;
        for(int i=1;i<=Math.sqrt(total);i++){
            if(total%i==0){
                int res[] = dfs(total/i, list, 0, -1, nums);
                if(res[0] != Integer.MAX_VALUE){
                    ans =Math.max(res[1], ans);
                }

                res = dfs(i, list, 0, -1, nums);
                if(res[0] != Integer.MAX_VALUE){
                    ans = Math.max(ans, res[1]);
                }
            }
        }

        return ans;
    }

    private int[] dfs(int sum, List<Integer> list[], int curr, int par, int nums[]){

        List<Integer> l = new ArrayList<>();
        int total = 0;
        int cnt = 0;
        for(int child : list[curr]){
            if(child != par){
                int res[] = dfs(sum, list, child, curr, nums);
                if(res[0] == Integer.MIN_VALUE){
                    return new int[]{Integer.MIN_VALUE, 0};
                }
                if(res[0]!=0){
                    l.add(res[0]);

                }
                cnt += res[1];
            }
        }

        if(l.size() > 2) return new int[]{Integer.MIN_VALUE, 0};

        total = nums[curr] + (!l.isEmpty() ? l.get(0) : 0) + (l.size() > 1 ? l.get(1) : 0);

        if(total == sum){
            return new int[]{0, cnt + (curr !=0 ? 1 : 0)};
        }
        if(total > sum){
            return new int[]{Integer.MIN_VALUE, 0};
        }

        return new int[]{total, cnt};
    }
}