package longest_almost_palindromic_substring_4221;

class Solution {
    public int almostPalindromic(String s) {
        int n = s.length();
        char ch[] = s.toCharArray();
        int ans = 0;

        for(int i=0;i<n;i++){
            int l = i;
            int r = i;

            while(l >=0 && r < n && ch[l] == ch[r]){
                ans = Math.max(ans, r - l + 2);
                l--;r++;
            }
            int ll = l-1, rr =r;
            while(ll >=0 && rr < n && ch[ll] == ch[rr]){
                ans= Math.max(ans, rr -ll + 1);
                ll--;
                rr++;
            }

            ll = l;
            rr = r + 1;
            while(ll >=0 && rr < n && ch[ll] == ch[rr]){
                ans = Math.max(ans, rr - ll + 1);
                ll--;
                rr++;
            }
        }

        for(int i=0;i<n;i++){
            var l = i;
            var r = i +1;
            while(l >=0 & r< n && ch[l] == ch[r]){
                ans = Math.max(ans, r - l +2);
                l--;
                r++;
            }

            int ll = l-1, rr = r;
            while(ll >=0 && rr < n && ch[ll] == ch[rr]){
                ans = Math.max(ans, rr - ll + 1);
                rr++;
                ll--;
            }

            ll = l;
            rr = r + 1;
            while(ll >=0 && rr < n && ch[ll] == ch[rr]){
                ans = Math.max(ans, rr -ll + 1);
                rr++;
                ll--;
            }
        }
        
        return Math.min(n, ans);
    }

}