package select_k_disjoint_special_substrings_3771;

import java.util.*;
class Solution {
    public boolean maxSubstringLength(String s, int k) {
        int n = s.length();
        int start[] = new int[26];
        int end[] = new int[26];
        Arrays.fill(start, -1);
        Arrays.fill(end, -1);
        for(int i=0;i<n;i++){
            int ind= s.charAt(i) - 'a';
            if(start[ind] == -1) start[ind] = i;
            end[ind] = i;
        }

        List<int[]> list =new ArrayList<>();

        for(int i=0;i<26;i++){
            int st = start[i];
            int en = end[i];
            if(st == -1) continue;
            boolean flag = true;
            for(int ind = st;ind<=en;ind++){
                int in = s.charAt(ind) - 'a';

                if(start[in] < st){
                    flag =false;
                    break;
                }

                en = Math.max(en, end[in]);

            }
            if(flag && (st > 0 || en < n-1)){
                list.add(new int[]{st, en});
            }
        }

        Collections.sort(list, (a,b) -> a[1] - b[1]);
        int ans = 0;
        int prev = -1;
        for(int in[] : list){
            if(in[0] > prev){
                prev = in[1];
                ans++;
            }
        }


        return ans >= k;
    }
}