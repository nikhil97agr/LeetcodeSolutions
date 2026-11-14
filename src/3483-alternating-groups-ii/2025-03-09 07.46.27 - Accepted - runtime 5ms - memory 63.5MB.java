class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int ans = 0;
        int n = colors.length;
        int start = 0;
        int end = 0;
        int cnt = 1;
        int e1 = 0;
        while(start < n){
            if(cnt < k){
                if(colors[end] != colors[(end+1)%n]){
                    cnt++;
                    end++;
                    end%=n;
                    e1++;
                }else{
                    cnt = 1;
                    start = e1+1;
                    e1++;
                    end = (end+1)%n;
                }
                continue;
            }
            
            ans++;
            if(colors[end] != colors[(end+1)%n]){
                end++;
                start++;
                end%=n;
                e1++;
            }else{
                cnt = 1;
                start = e1+1;
                end++;
                end%=n;
                e1++;
            }
        }
        return ans;
    }
}