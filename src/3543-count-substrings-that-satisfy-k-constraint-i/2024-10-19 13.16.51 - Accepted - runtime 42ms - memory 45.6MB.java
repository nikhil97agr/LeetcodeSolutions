class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int ans = 0;

        for(int i=0;i<n;i++){
            String str = "";
            for(int j=i;j<n;j++){
                str += s.charAt(j);

                int zero = 0;
                int one = 0;

                for(char c : str.toCharArray()){
                    if(c=='0') zero++;
                    else one++;
                }
                if(one <= k || zero<=k) ans++;
            }
        }
        return ans;
    }
}