class Solution {
    public int maxSubstringLength(String s) {
        int ans = -1;
        int start[] = new int[26];
        int end[] = new int[26];
        Arrays.fill(start, -1);
        Arrays.fill(end, -1);
        int n = s.length();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            int ind = c- 'a';
            if(start[ind] == -1){
                start[ind] = i;
            }
            end[ind] = i;
        }

        for(char c= 'a';c<='z';c++){
            int l = start[c-'a'];
            int r = end[c-'a'];
            if(l==-1) continue;

            for(int i=l;i<n;i++){
                int i1 = s.charAt(i) - 'a';
                if(start[i1] < l) break;

                r = Math.max(r, end[i1]);

                if( r== i && r - l + 1 != n){
                    ans = Math.max(ans, r - l + 1);
                }
            }
        }

        return ans;
    }
}