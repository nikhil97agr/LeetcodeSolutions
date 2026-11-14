package alternating_groups_i_3463;

class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int ans = 0;
        int n = colors.length;
        
        for(int i=0;i<n;i++){
            int f = i;
            int s = (i+1)%n;
            int t = (i+2)%n;
            
            if(colors[f] != colors[s] && colors[s] != colors[t]){
                ans++;
            }
        }
        return ans;
    }
}