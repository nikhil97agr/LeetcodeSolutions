class Solution {
    public int largestComponentSize(int[] nums) {
        int  n = nums.length;
        int par[] = new int[n];
        for(int i=0;i<n;i++){
            par[i] = i;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int val = nums[i];

            for(int j=2;j<=Math.sqrt(val);j++){
                if(val%j==0){
                    map.computeIfAbsent(j, x -> new ArrayList<>()).add(i);

                    while(val%j==0) val/=j;
                }
            }

            if( val > 1){
                map.computeIfAbsent(val, x-> new ArrayList<>()).add(i);
            }
        }

        for(List<Integer> list : map.values()){
            int first = list.get(0);
            int p = find(par, first);

            for(int x : list){
                int p1 = find(par, x);
                if(p!= p1){
                    par[p1] = p;
                }
            }
        }
        int ans = 0;
        Map<Integer, Integer> cnt =new HashMap<>();
        for(int i=0;i<n;i++){
            int p = find(par, i);
            cnt.merge(p, 1, Integer::sum);
        }

        for(int v : cnt.values()){
            ans = Math.max(ans, v);
        }

        return ans;
    }

    private int find(int par[], int p){
        if(par[p] == p) return p;

        return par[p] = find(par, par[p]);
    }
}