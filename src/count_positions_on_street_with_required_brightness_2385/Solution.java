package count_positions_on_street_with_required_brightness_2385;

class Solution {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int ans = 0;
        int pre[] = new int[200001];
        for(int l[] : lights){
            int pos = l[0];
            int r= l[1];
            int start = Math.max(0, pos - r);
            int end = Math.min(n, pos + r + 1);
            pre[start]++;
            pre[end]--;
        }
        int cnt = 0;
        for(int i=0;i<n;i++){
            cnt += pre[i];
            if(cnt >= requirement[i]){
                ans++;
            }
        }

        return ans;
    }
}