package total_appeal_of_a_string_2340;

import java.util.*;
class Solution {
    public long appealSum(String s) {
        long ans = 0;
        int n = s.length();
        int prev[] = new int[26];
        Arrays.fill(prev, -1);
        for(int i=0;i<n;i++){
            int ind = s.charAt(i) - 'a';
            int left = i - prev[ind] - 1;
            int right = n- i - 1;
            ans += 1l * left * right + left + right + 1;
            prev[ind] = i;
        }

        return ans;
    }
}