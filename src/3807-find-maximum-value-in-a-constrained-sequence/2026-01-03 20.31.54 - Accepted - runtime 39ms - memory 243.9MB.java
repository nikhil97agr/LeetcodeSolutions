class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int r[] : restrictions){
            map.put(r[0], r[1]);
        }
        map.put(0, 0);

        int h[] = new int[n];
        for(int i=1;i<n;i++){
            h[i] = h[i-1] + diff[i-1];

            if(map.containsKey(i)){
                h[i] = Math.min(h[i], map.get(i));
            }
        }

        for(int i=n-2;i>=0;i--){
            h[i] = Math.min(h[i], h[i+1] + diff[i]);
            
        }
        int ans = 0;
        for(int x : h){
            ans = Math.max(x, ans);
        }
        return ans;
    }
}