package count_substrings_that_satisfy_k_constraint_i_3543;

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